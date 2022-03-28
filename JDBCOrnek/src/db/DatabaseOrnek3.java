package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOrnek3 extends DBBase {
	public static void main(String[] args) {
		new DatabaseOrnek3().run();
	}

	public void run() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from personel");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String adi = rs.getString("adi");
				String soyadi = rs.getString("soyadi");
				System.out.println(
						"Id: " + id + ", Adi: " + adi + ", Soyadi: " + soyadi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt);
		}
		closeConnection();
	}
}
