import java.sql.*;

public class DatabaseConnector {

    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/bookstore";

    public boolean connect(String username, String password) {
        boolean flag = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");
            flag = true;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
        } catch (SQLException s) {
            System.out.println("Error connecting to database: " + s.getMessage());
            s.printStackTrace();
        }
        return flag;
    }

    // return connection
    public Connection getConnection() {
        return connection;
    };

    // Method to create a table in the database.
    public boolean createTable() {
        if (connection == null) {
            System.out.println("Please connect to the database first.");
            return false;
        }
        try (Statement statement = connection.createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS Books(" +
                    "bookID INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "title VARCHAR(255) NOT NULL," +
                    "author VARCHAR(100) NOT NULL," +
                    "price DOUBLE NOT NULL)";
            statement.executeUpdate(query);
            System.out.println("Table created");
            return true;
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

}