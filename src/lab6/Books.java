package lab6;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private Date dueDate;
    private double fine;

    // Constructor
    public Book(int id, String title, String author, double price, Date dueDate, double fine) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.dueDate = dueDate;
        this.fine = fine;
    }

    // Getters and setters for new fields
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    // toString method
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", dueDate=" + dueDate +
                ", fine=" + fine +
                '}';
    }
}

class DatabaseOperations {

    private Connection connection;

    // CONSTRUCTOR
    public DatabaseOperations(Connection connection) {
        this.connection = connection;
    }

    public void insertBook(Book book) throws SQLException {
        String query = "INSERT INTO books (title, author, price, due_date, fine) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setDate(4, new java.sql.Date(book.getDueDate().getTime())); // Convert Date to SQL Date
            statement.setDouble(5, book.getFine());
            statement.executeUpdate();
        }
    }

    public Book retrieveBook(int id) throws SQLException {
        String query = "SELECT * FROM books WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Book(resultSet.getInt("id"), resultSet.getString("title"),
                            resultSet.getString("author"), resultSet.getDouble("price"),
                            resultSet.getDate("due_date"), resultSet.getDouble("fine"));
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
                    books.add(new Book(resultSet.getInt("id"), resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getDouble("price")));
                }
                return books;
            }
        }
    }
}