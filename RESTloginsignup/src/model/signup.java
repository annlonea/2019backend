package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class signup {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", ";';'");
			//String username = "testusername";
			String OGpassword = "testpw";
			String SHpassword = password.encPassword(OGpassword);
			String DBpassword = "'{" + SHpassword + "}'";
			String email = "'{testEmail}'";
			String fname = "'{testFname}'";
			String lname = "'{testLname}'";
			String uname = "'{testUname}'";
			
			String sqlstmt = "INSERT INTO public.\"user\"(\n" + 
					"	firstname, lastname, email, username, password)\n" + 
					"	VALUES (" + fname + ","+ lname + "," + email + "," + uname + "," + DBpassword +  ");";
			
			PreparedStatement stmt = con.prepareStatement(sqlstmt);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3)+rs.getString(6)+rs.getString(7)+rs.getString(8));
			}
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}


