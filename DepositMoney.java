import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DepositMoney {

    public static void deposit() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE account SET balance = balance + ? WHERE account_number=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setString(2, accNo);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Amount deposited successfully!");
            else
                System.out.println("❌ Account not found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}