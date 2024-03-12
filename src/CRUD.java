import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUD {
    public ArrayList<Employee> getEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        DataBaseConnector dataBaseConnector;
        dataBaseConnector = DataBaseConnector.getInstance();
        Connection con;
        con = dataBaseConnector.getConnection();
        Statement stmnt;
        try {
            stmnt = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet rs = stmnt.executeQuery("select * from employee");
            while (rs.next()) {
                String name = rs.getString("emp_name");
                String address = rs.getString("emp_address");
                Employee employee = new Employee(name, address);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return employees;
    }
}
