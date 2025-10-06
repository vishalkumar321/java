import java.util.*;

class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int accountNumber = sc.nextInt();
        double balance = sc.nextDouble();
        double deposit = sc.nextDouble();
        double withdraw = sc.nextDouble();

        if (accountNumber <= 0 || balance < 0 || deposit < 0 || withdraw < 0) {
            System.out.println("Invalid Input values.");
            return;
        }

        balance += deposit;
        if (withdraw > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= withdraw;
            System.out.println(balance);
        }
    }
}
