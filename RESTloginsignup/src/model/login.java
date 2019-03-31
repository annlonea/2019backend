package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class login {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", ";';'");
			
			//wrong PW ok
			//String wrongPw = "wrongPw";
			String INpassword = "testpw";
			String SHpassword = password.encPassword(INpassword);
			System.out.println(SHpassword);
			String DBpassword = "'{" + SHpassword + "}'";
			String uname = "'{testUname}'";
			
			
			
			String sqlstmt = "SELECT firstname, lastname, email, phone, profilepic, username, password, id, point, level " + 
								"FROM public.\"user\"" + 
								"WHERE username = " + uname + " and password = " + DBpassword + ";";
			
			
			PreparedStatement stmt = con.prepareStatement(sqlstmt);
			
			ResultSet rs = stmt.executeQuery();
			
			if (!rs.next()) {
				System.out.println("invalid username and password combination");
			}
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3)+rs.getString(6)+rs.getString(7)+rs.getString(8));
			}
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}

