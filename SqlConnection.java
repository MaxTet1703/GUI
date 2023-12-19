import java.sql.*;
import java.sql.DriverManager;

public class SqlConnection {
    static final String URL = "jdbc:postgresql://127.0.0.1:5432/gui";
    static final String name = "maxim";
    static final String password = "12345";
    Statement st;
    Connection conn;
    public SqlConnection(){

    }
    private Connection getConnection(){
        conn = null;
        try {
            conn = DriverManager.getConnection(URL, name, password);
            return conn;

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getData(String query){
        ResultSet result = null;
        try{
            st = getConnection().createStatement();
            result = st.executeQuery(query);
            return result;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection(){
        try{
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}