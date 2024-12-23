public class Main {
    public static void main(String[] args) {
        // Creating an instance of the BookQueue
        BookQueue bookQueue = new BookQueue();

        // Simulating scraped books data (as an example)
        String[] scrapedBooks = {
                "Book 1: Java Programming",
                "Book 2: Data Structures",
                "Book 3: Algorithms",
                "Book 4: Design Patterns",
                "Book 5: Clean Code",
                "Book 6: Effective Java",
                "Book 7: Head First Java",
                "Book 8: Spring in Action",
                "Book 9: Hibernate for Beginners",
                "Book 10: Microservices Patterns"
        };

        // Adding scraped books to the queue
        for (String book : scrapedBooks) {
            bookQueue.add(book);
        }

        // Printing all books in the queue before sorting
        System.out.println("\n--- Printing all books in the queue before sorting ---");
        bookQueue.printAll();

        // Sorting the queue
        bookQueue.sortQueue();

        // Printing all books in the queue after sorting
        System.out.println("\n--- Printing all books in the queue after sorting ---");
        bookQueue.printAll();
    }
}