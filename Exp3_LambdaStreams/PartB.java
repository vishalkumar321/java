
import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return String.format("Name: %-10s | Marks: %.2f", name, marks);
    }
}

public class PartB {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Vishal", 92),
            new Student("Riya", 65),
            new Student("Ankit", 81),
            new Student("Neha", 74),
            new Student("Rohit", 89)
        );

        System.out.println("All Students:");
        students.forEach(System.out::println);

        System.out.println("\nStudents with Marks > 75 (Sorted by Marks):");

        students.stream()
                .filter(s -> s.getMarks() > 75)                 // Filter condition
                .sorted(Comparator.comparingDouble(Student::getMarks)) // Sort ascending
                .map(Student::getName)                         // Map to names
                .forEach(System.out::println);                 // Display names
    }
}
