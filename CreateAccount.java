import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CreateAccount {

    public static void createAccount() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter user_id: ");
        int userId = sc.nextInt();

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        System.out.print("Enter Account Type: ");
        String accType = sc.next();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO account(user_id, account_number, account_type, balance) VALUES (?,?,?,0)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setString(2, accNo);
            ps.setString(3, accType);

            ps.executeUpdate();
            System.out.println("Account created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
