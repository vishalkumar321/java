import java.util.*;

class LibraryItem {
    int itemId;
    int titleCode;
    boolean available;

    LibraryItem(int itemId, int titleCode, boolean available) {
        this.itemId = itemId;
        this.titleCode = titleCode;
        this.available = available;
    }
}

class Book extends LibraryItem {
    Book(int itemId, int titleCode, boolean available) {
        super(itemId, titleCode, available);
    }

    void checkOut() {
        if (available) {
            available = false;
            System.out.println("Book Checked Out Successfully.");
        } else {
            System.out.println("Already checked out.");
        }
    }

    void returnBook() {
        if (!available) {
            available = true;
            System.out.println("Book Returned Successfully.");
        } else {
            System.out.println("Already available.");
        }
    }

    void displayDetails() {
        System.out.println("Book ID: " + itemId);
        System.out.println("Title Code: " + titleCode);
        System.out.println("Available: " + available);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int code = sc.nextInt();
        int avail = sc.nextInt();

        Book b = new Book(id, code, avail == 1);

        while (sc.hasNextInt()) {
            int op = sc.nextInt();
            switch (op) {
                case 1 -> b.checkOut();
                case 2 -> b.returnBook();
                case 3 -> b.displayDetails();
                default -> System.out.println("Invalid operation.");
            }
        }
    }
}
