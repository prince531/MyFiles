import java.io.*;
import java.sql.*;

public class JDBC {

	public static void main(String args[]) {
		String name = null;
		String password = null;
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter name and password : ");
		try {
			name = br.readLine();
			password = br.readLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			Statement st = con.createStatement();
			
			int result = st.executeUpdate("insert into emp1 values('"+name+"','"+password+"')");
			System.out.println("Records are insert successful");
			//int result = st.executeUpdate("delete from emp where name='"+name+"'and password='"+password+"'");
			//System.out.println("Records are delete successful");
			//int result = st.executeUpdate("update emp set name='raj' where name'Prince'") ;
			//System.out.println("Records are update successful");
			
			ResultSet rs = st.executeQuery("select * from emp1");
			System.out.println("Records are : ");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
