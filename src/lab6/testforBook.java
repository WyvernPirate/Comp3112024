package lab6;

public class TestForBook {
    public static void main(String[] args) {
        // connecting to the database
        DatabaseConnector connector = new DatabaseConnector();
        connector.connect("Phemelo", "123456");
        // creating a table
        connector.createTable();
        DatabaseOperations n = new DatabaseOperations(connector.getConnection());

        // inserting 5 books into the table
        n.insertBook("The Great Gatsby", "F. Scott Fitzgerald", 340);
        n.insertBook("1984", "George Orwell", 300);
        n.insertBook("The Catcher in the Rye", "J.D. Salinger", 500);
        n.insertBook("The Lord of the Rings", "J.R.R. Tolkien", 750);
        n.insertBook("The Hunger Games", "Suzanne Collins", 200);

        // UPDATE ONE BOOK
        n.updateBook(1, "The Great Gatsby", "Phemelo Moloi", 350);

        // DELETE ONE BOOK
        n.deleteBook("1984");

        // RETRIEVE ALL BOOKS
        Book[] allBooks = n.retrieveAllBooks();
        for (Book book : allBooks) {
            System.out.println(
                    "Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Pages: " + book.getPages());
        }

        // SEARCH FOR BOOKS
        Book searchBook = new Book("Book1", "", 0);

    }

}