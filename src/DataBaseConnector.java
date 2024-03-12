import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {
    private static DataBaseConnector  dataBaseConnector;
    private String database = "jdbc:mysql://localhost:3306/org";
    private  String username  = "otto";
    private String password = "root";
 private Connection connection = null;



    private void createConnection() {
        if (connection != null)
            return; // If connection already created, just return that to ensure singleton

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(database, username, password);
        } catch (Exception e) {

        }
    }
    private  DataBaseConnector () {
    createConnection();
    }
    public static DataBaseConnector getInstance() {
        if(dataBaseConnector==null) {
            dataBaseConnector = new DataBaseConnector();
        } return dataBaseConnector;
    }
    public Connection getConnection() {
        return  connection;
    }
}
