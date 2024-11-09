import java.sql.*;

public class DatabaseConnector {
    // connect to the sql database

    private Connection conn = null;
    public String url = "jdbc:mysql://localhost:3306"

    public void connect() {

        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            this.conn = DriverManager.getConnection(null, null, null)

    }
}