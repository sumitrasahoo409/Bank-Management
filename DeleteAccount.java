import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteAccount {

    public static void deleteAccount() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM account WHERE account_number=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, accNo);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("🗑️ Account deleted successfully!");
            else
                System.out.println("❌ Account not found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
