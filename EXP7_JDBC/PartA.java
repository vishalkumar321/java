import java.sql.*;

public class PartA {
    public static void main(String[] args) {
        String url = "jdbc:mysql://bytexldb.com:5051/db_43zwsgrsn";
        String user = "user_43zwsgrsn";
        String password = "p43zwsgrsn";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Create statement
            Statement stmt = con.createStatement();

            // Execute SELECT query
            ResultSet rs = stmt.executeQuery("SELECT EmpID, Name, Salary FROM Employee");

            // Display results
            System.out.println("EmpID\tName\tSalary");
            while (rs.next()) {
                int empId = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println(empId + "\t" + name + "\t" + salary);
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
