import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class BookQueue {
    private Queue<String> queue;

    // Constructor
    public BookQueue() {
        this.queue = new LinkedList<>();
    }

    // Method to add a book to the queue
    public void add(String book) {
        queue.offer(book); // Adds to the queue
        System.out.println("Added book: " + book);
    }

    // Method to remove a book from the queue
    public String remove() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty, nothing to remove!");
            return null;
        }
        String removedBook = queue.poll(); // Removes from the front of the queue
        System.out.println("Removed book: " + removedBook);
        return removedBook;
    }

    // Method to print all books in the queue
    public void printAll() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty!");
            return;
        }
        System.out.println("Books in the queue:");
        for (String book : queue) {
            System.out.println(book);
        }
    }

    // Method to search for a book in the queue
    public boolean search(String book) {
        if (queue.contains(book)) {
            System.out.println("Book found: " + book);
            return true;
        } else {
            System.out.println("Book not found: " + book);
            return false;
        }
    }

    // Method to sort the books in the queue using selection sort
    public void sortQueue() {
        // Converting the queue to a list for sorting
        List<String> list = new ArrayList<>(queue);

        // Performing selection sort on the list
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swapping the found minimum element with the first element
            String temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }


        queue.clear();
        queue.addAll(list);

        System.out.println("Queue sorted using selection sort.");
    }
}