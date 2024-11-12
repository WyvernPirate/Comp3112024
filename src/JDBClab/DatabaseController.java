import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DatabaseController {

    // instance variables
    private Connection conn = null;
    private String url = "jdbc:mysql://localhost:3306/shop";

    // method to connect to the database
    public boolean connect(String username, String password) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create a Properties object to store the username and password
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);

            // establish the connection
            conn = DriverManager.getConnection(url, props);
            System.out.println("Connection successful");

            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            return false;
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return false;
        }
    }

    public boolean addProduct(Product p) {
        boolean flag = false;
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, p.getName());
            statement.setDouble(2, p.getPrice());
            statement.setInt(3, p.getQuantity());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record added successfully");
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("Error inserting product: ");
            e.printStackTrace();
        }
        return flag;
    }

    // method to get all products and store them in an ArrayList
    public void productsToList(ResultSet r, ArrayList<Product> list) {
        try {
            while (r.next()) {
                int id = r.getInt("Id");
                String name = r.getString("Name");
                double price = r.getDouble("Price");
                int quantity = r.getInt("Quantity");

                Product p = new Product(id, name, price, quantity);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching products: ");
            e.printStackTrace();
        }
    }

    // method to get all products from the table and returns an ArrayList of all
    // products
    public ArrayList getProducts() {
        ArrayList arr = new ArrayList<Product>();
        try {
            Statement statement = conn.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM products");
            productsToList(r, arr);

        } catch (SQLException e) {
            System.out.println("Error fetching products: ");
            e.printStackTrace();
        }
        return arr;
    }

}