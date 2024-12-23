import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BooksToScrape {
    public static void main(String[] args) {
        // URL of the website to scrape
        String baseUrl = "http://books.toscrape.com/catalogue/page-";
        int maxPages = 5; // Number of pages to scrape (can be increased as needed)

        // List to store scraped data
        List<String[]> bookData = new ArrayList<>();

        try {
            // Loop through multiple pages of the website
            for (int page = 1; page <= maxPages; page++) {

                String url = baseUrl + page + ".html";
                Document doc = Jsoup.connect(url).get();

                // Selecting book elements
                Elements books = doc.select("article.product_pod");

                // Extracting data for each book
                for (Element book : books) {
                    String title = book.select("h3 a").attr("title"); // Book title
                    String price = book.select("p.price_color").text(); // Price
                    String availability = book.select("p.instock.availability").text().trim(); // Availability
                    String rating = book.select("p").attr("class").replace("star-rating", "").trim(); // Rating

                    // Adding data as a row to the list
                    bookData.add(new String[]{title, price, availability, rating});
                }
            }

            // Saving the scraped data to a CSV file
            saveToCSV(bookData, "books_data.csv");
            System.out.println("Data scraped and saved to books_data.csv successfully!");

        } catch (IOException e) {
            System.err.println("Error fetching the webpage: " + e.getMessage());
        }
    }

    // Function to save data to a CSV file
    private static void saveToCSV(List<String[]> data, String fileName) {
        try (FileWriter csvWriter = new FileWriter(fileName)) {
            // Write the header row
            csvWriter.append("Title,Price,Availability,Rating\n");

            // Write data rows
            for (String[] row : data) {
                csvWriter.append(String.join(",", row));
                csvWriter.append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }
}