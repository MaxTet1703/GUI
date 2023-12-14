import java.sql.*;
import java.sql.DriverManager;

public class SqlConnection {
    static final String URL = "jdbc:postgresql://127.0.0.1:5432/gui";
    static final String name = "maxim";
    static final String password = "12345";

    static final String firstQuery = "SELECT * FROM item";
    public SqlConnection(){
        Connection conn = getConnection();
        Statement st = null;
        try{
            st = conn.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
        if (st != null){
           try{
               st.execute(firstQuery);
           }catch (Exception e){
               e.printStackTrace();
           }
        }
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