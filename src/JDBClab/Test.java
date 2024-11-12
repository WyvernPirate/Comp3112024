package JDBClab;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // create new objects
        DatabaseController data = new DatabaseController();
        data.connect("Phemelo", "123456");

        // create a new product
        Product p1 = new Product(1, "Coke", 13.5, 10);
        Product p2 = new Product(2, "Fanta", 12.5, 12);
        Product p3 = new Product(3, "Sprite", 11.5, 15);
        Product p4 = new Product(4, "Water", 10, 20);
        Product p5 = new Product(2, "Wine", 125, 3);

        // add product to database
        data.addProduct(p1);
        data.addProduct(p2);
        data.addProduct(p3);
        data.addProduct(p4);
        data.addProduct(p5);

        // getting contents from table and adding to and Arraylist
        ArrayList<Product> products = data.getProducts();

        // Print each product in the ArrayList
        for (Product p : products) {
            System.out.println("Id: " + p.getId() +
                    " Product: " + p.getName() +
                    ", Price: " + p.getPrice() +
                    ", Quantity: " + p.getQuantity());
        }
    }
}