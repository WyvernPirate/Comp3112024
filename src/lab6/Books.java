```java
public class Book {

    private int id;
    private String title;
    private String author;
    private double price;

    // CONSTRUCTOR
    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

class DatabaseOperations {

    private Connection connection;

    // CONSTRUCTOR
    public DatabaseOperations(Connection connection) {
        this.connection = connection;
    }

    // METHOD TO INSERT BOOK INTO DATABASE
    public void insertBook(Book book) throws SQLException {
        String query = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.executeUpdate();
        }
    }

    // METHOD TO RETRIEVE BOOK FROM DATABASE
    public Book retrieveBook(int id) throws SQLException {
        String query = "SELECT * FROM books WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Book(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("author"),
                            resultSet.getDouble("price"));
                } else {
                    return null;
                }
            }
        }
    }

    // METHOD TO UPDATE BOOK IN DATABASE
    public void updateBook(Book book) throws SQLException {
        String query = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getId());
            statement.executeUpdate();
        }
    }

    // METHOD TO DELETE BOOK FROM DATABASE
    public void deleteBook(String title) throws SQLException {
        String query = "DELETE FROM books WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setTitle(1, title);
            statement.executeUpdate();
        }
    }

    // METHOD TO RETRIEVE ALL ROWS FROM DATABASE
    public List<Book> retrieveAllBooks() throws SQLException {
        String query = "SELECT * FROM books";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("author"),
                        resultSet.getDouble("price")));
            }
            return books;
        }
    }

    // METHOD TO SEARCH FOR BOOKS BY TITLE, AUTHOR, OR PRICE RANGE
    public List<Book> searchBooks(String title, String author, double minPrice, double maxPrice) throws SQLException {
        String query = "SELECT * FROM books WHERE title LIKE ? AND author LIKE ? AND price BETWEEN ? AND ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + title + "%");
            statement.setString(2, "%" + author + "%");
            statement.setDouble(3, minPrice);
            statement.setDouble(4, maxPrice);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Book> books = new ArrayList<>();
                while (resultSet.next()) {
                    books.add(new Book(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("author"),
                            resultSet.getDouble("price")));
                }
                return books;
            }
        }
    }
}