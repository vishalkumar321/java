import java.util.Scanner;

public class SquareRootCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double num = sc.nextDouble();
            if (num < 0) {
                System.out.println("Cannot calculate square root of a negative number.");
            } else {
                System.out.println("Square root of " + num + " is " + Math.sqrt(num));
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
    }
}
