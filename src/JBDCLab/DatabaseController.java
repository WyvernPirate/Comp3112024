package JBDCLab;

import java.util.*;
import java.sql.*;

public class DatabaseController {

    // instance variables
    public Connection conn = null;

    // method to connect to the database
    public boolean connect() {
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?user=root");

            flag = true;
            System.out.println("connection successful");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
        } catch (SQLException s) {
            System.out.println("connection failed");
        }
        return flag;
    }

}
