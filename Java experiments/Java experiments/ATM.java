import java.util.*;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double balance = sc.nextDouble();
            double withdraw = sc.nextDouble();

            if (withdraw <= 0) {
                System.out.println("Invalid withdrawal amount.");
            } else if (withdraw % 100 != 0) {
                System.out.println("Withdrawal amount must be in multiples of 100.");
            } else if (withdraw > balance) {
                System.out.println("Insufficient balance. Withdrawal failed.");
            } else {
                balance -= withdraw;
                System.out.println("Withdrawal successful. Remaining balance: ₹" + balance);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
    }
}
