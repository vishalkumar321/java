import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PartC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://bytexldb.com:5051/db_43zwsgrsn";
        String user = "user_43zwsgrsn";
        String password = "p43zwsgrsn";


        Scanner sc = new Scanner(System.in);
        try {
            StudentController controller = new StudentController(url, user, password);

            while (true) {
                System.out.println("\n--- Student Management ---");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("StudentID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Department: "); String dept = sc.nextLine();
                        System.out.print("Marks: "); double marks = sc.nextDouble(); sc.nextLine();
                        controller.addStudent(new Student(id, name, dept, marks));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        List<Student> students = controller.getAllStudents();
                        System.out.println("ID\tName\tDepartment\tMarks");
                        for (Student s : students) {
                            System.out.println(s.getStudentID() + "\t" + s.getName() + "\t" + s.getDepartment() + "\t" + s.getMarks());
                        }
                        break;

                    case 3:
                        System.out.print("StudentID to update: "); int uid = sc.nextInt(); sc.nextLine();
                        System.out.print("New Name: "); String uname = sc.nextLine();
                        System.out.print("New Department: "); String udept = sc.nextLine();
                        System.out.print("New Marks: "); double umarks = sc.nextDouble(); sc.nextLine();
                        controller.updateStudent(new Student(uid, uname, udept, umarks));
                        System.out.println("Student updated successfully.");
                        break;

                    case 4:
                        System.out.print("StudentID to delete: "); int did = sc.nextInt(); sc.nextLine();
                        controller.deleteStudent(did);
                        System.out.println("Student deleted successfully.");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
