import java.util.*;

abstract class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void displayDetails();
}

class Student extends Person {
    int rollNumber;

    Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }

    void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll Number: " + rollNumber);
    }
}

class Teacher extends Person {
    int subjectCode;

    Teacher(String name, int age, int subjectCode) {
        super(name, age);
        this.subjectCode = subjectCode;
    }

    void displayDetails() {
        System.out.println("Teacher Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject Code: " + subjectCode);
    }
}

public class PersonMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        String name = sc.next();
        int age = sc.nextInt();

        if (age <= 0) {
            System.out.println("Invalid Input");
            return;
        }

        if (type == 1) {
            int roll = sc.nextInt();
            new Student(name, age, roll).displayDetails();
        } else if (type == 2) {
            int code = sc.nextInt();
            new Teacher(name, age, code).displayDetails();
        } else {
            System.out.println("Invalid Input");
        }
    }
}
