import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySql {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from emp1");
			System.out.println("Records are : ");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("Connection not aviliable");
		}
	}
}
