package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOrnek2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5433/sayistay", "postgres",
					"postgres");
			stmt = conn.prepareStatement("select * from personel");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String adi = rs.getString("adı");
				String soyadi = rs.getString("soyadi");
				System.out.println(
						"Id: " + id + ", Adi: " + adi + ", Soyadi: " + soyadi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			} finally {
				try {
					stmt.close();
				} catch (Exception e) {
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
		}
	}
}
