import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class WithdrawMoney {

    public static void withdraw() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();

        try {
            Connection con = DBConnection.getConnection();

            String checkSql = "SELECT balance FROM account WHERE account_number=?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setString(1, accNo);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");

                if (balance >= amount) {
                    String sql = "UPDATE account SET balance = balance - ? WHERE account_number=?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setDouble(1, amount);
                    ps.setString(2, accNo);
                    ps.executeUpdate();

                    System.out.println("✅ Withdrawal successful!");
                } else {
                    System.out.println("❌ Insufficient balance");
                }
            } else {
                System.out.println("❌ Account not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
