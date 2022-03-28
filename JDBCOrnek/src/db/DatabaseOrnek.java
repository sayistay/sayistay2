package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOrnek {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5433/sayistay", "postgres",
					"postgres");
			PreparedStatement stmt = conn.prepareStatement("select * from personel");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String adi = rs.getString("adi");
				String soyadi = rs.getString("soyadi");
				System.out.println(
						"Id: " + id + ", Adi: " + adi + ", Soyadi: " + soyadi);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
