import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CheckBalance {

    public static void checkBalance() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT balance FROM account WHERE account_number=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, accNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(" Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println(" Account not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
