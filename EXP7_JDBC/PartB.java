import java.sql.*;
import java.util.Scanner;

public class PartB {
    private static final String URL = "jdbc:mysql://bytexldb.com:5051/db_43zwsgrsn";
    private static final String USER = "user_43zwsgrsn";
    private static final String PASSWORD = "p43zwsgrsn";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            con.setAutoCommit(false); // Enable transaction

            while (true) {
                System.out.println("\n--- Product Management ---");
                System.out.println("1. Create Product");
                System.out.println("2. Read Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1: // Create
                        System.out.print("Product Name: ");
                        String name = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        try (PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO Product (ProductName, Price, Quantity) VALUES (?, ?, ?)")) {
                            ps.setString(1, name);
                            ps.setDouble(2, price);
                            ps.setInt(3, qty);
                            ps.executeUpdate();
                            con.commit();
                            System.out.println("Product inserted successfully.");
                        } catch (SQLException e) {
                            con.rollback();
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2: // Read
                        try (Statement stmt = con.createStatement();
                             ResultSet rs = stmt.executeQuery("SELECT ProductID, ProductName, Price, Quantity FROM Product")) {
                            System.out.println("ID\tName\tPrice\tQuantity");
                            while (rs.next()) {
                                System.out.println(rs.getInt("ProductID") + "\t" +
                                        rs.getString("ProductName") + "\t" +
                                        rs.getDouble("Price") + "\t" +
                                        rs.getInt("Quantity"));
                            }
                        }
                        break;

                    case 3: // Update
                        System.out.print("Enter ProductID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Name: ");
                        String newName = sc.nextLine();
                        System.out.print("New Price: ");
                        double newPrice = sc.nextDouble();
                        System.out.print("New Quantity: ");
                        int newQty = sc.nextInt();
                        try (PreparedStatement ps = con.prepareStatement(
                                "UPDATE Product SET ProductName=?, Price=?, Quantity=? WHERE ProductID=?")) {
                            ps.setString(1, newName);
                            ps.setDouble(2, newPrice);
                            ps.setInt(3, newQty);
                            ps.setInt(4, updateId);
                            int rows = ps.executeUpdate();
                            if (rows > 0) {
                                con.commit();
                                System.out.println("Product updated successfully.");
                            } else {
                                System.out.println("Product not found.");
                                con.rollback();
                            }
                        } catch (SQLException e) {
                            con.rollback();
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4: // Delete
                        System.out.print("Enter ProductID to delete: ");
                        int delId = sc.nextInt();
                        try (PreparedStatement ps = con.prepareStatement("DELETE FROM Product WHERE ProductID=?")) {
                            ps.setInt(1, delId);
                            int rows = ps.executeUpdate();
                            if (rows > 0) {
                                con.commit();
                                System.out.println("Product deleted successfully.");
                            } else {
                                System.out.println("Product not found.");
                                con.rollback();
                            }
                        } catch (SQLException e) {
                            con.rollback();
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
