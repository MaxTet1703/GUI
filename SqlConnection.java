import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    static final String URL = "jdbc:postgresql://127.0.0.1:5432/gui";
    static final String name = "maxim";
    static final String password = "12345";
    public SqlConnection(){
        getConnection();
    }
    private Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, name, password);
            return conn;

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return null;
    }
}