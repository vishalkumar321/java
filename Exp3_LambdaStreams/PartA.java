
import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("Name: %-10s | Age: %-3d | Salary: %.2f", name, age, salary);
    }
}

public class PartA {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Vishal", 25, 55000));
        employees.add(new Employee("Ankit", 28, 60000));
        employees.add(new Employee("Rahul", 23, 45000));
        employees.add(new Employee("Riya", 26, 70000));

        System.out.println("Original List:");
        employees.forEach(System.out::println);

        // Sort by Name (Alphabetically)
        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        System.out.println("\nSorted by Name:");
        employees.forEach(System.out::println);

        // Sort by Age (Ascending)
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("\nSorted by Age:");
        employees.forEach(System.out::println);

        // Sort by Salary (Descending)
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("\nSorted by Salary (Descending):");
        employees.forEach(System.out::println);
    }
}

