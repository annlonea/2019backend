package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class testpostgre {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", ";';'");
			//update email OK
			//PreparedStatement stmt1 = con.prepareStatement("UPDATE public.\"user\" SET email = '{newemail}' WHERE username = '{testu2}';");
			//ResultSet rs1 = stmt1.executeQuery();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM public.\"user\";");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3)+rs.getString(6)+rs.getString(7)+rs.getString(8));
			}
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
