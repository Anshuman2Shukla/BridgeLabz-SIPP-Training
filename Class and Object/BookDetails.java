class Book {
    // Attributes (data members) of the Book class
    String title;
    String author;
    double price;

    // Constructor to initialize the book details
    Book(String title, String author, double price) {
        this.title = title;     // 'this' refers to the current object's title
        this.author = author;   // Assign author
        this.price = price;     // Assign price
    }

    // Method to display the book details
    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

// Main class to test the Book class
public class BookDetails {
    public static void main(String[] args) {
        // Create a Book object using the constructor
        Book myBook = new Book("The Alchemist", "Paulo Coelho", 399.50);

        // Call method to display book details
        myBook.displayDetails();
    }
}
