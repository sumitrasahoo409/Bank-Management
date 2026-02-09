import java.util.Scanner;

public class main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n BANK MANAGEMENT SYSTEM");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> CreateAccount.createAccount();
                case 2 -> CheckBalance.checkBalance();
                case 3 -> DepositMoney.deposit();
                case 4 -> WithdrawMoney.withdraw();
                case 5 -> DeleteAccount.deleteAccount();
                case 6 -> System.out.println(" Thank you!");
                default -> System.out.println(" Invalid choice");
            }

        } while (choice != 6);
    }
}
