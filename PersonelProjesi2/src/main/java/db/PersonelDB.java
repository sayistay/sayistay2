package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Personel;

public class PersonelDB extends DBBase {
	public List<Personel> getPersoneller() {
		List<Personel> liste = new ArrayList<Personel>();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn.prepareStatement("select * from personel").executeQuery();
			stmt = conn.prepareStatement("select * from personel");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String adi = rs.getString("adi");
				String soyadi = rs.getString("soyadi");
				Personel personel = new Personel();
				personel.setId(id);
				personel.setAdi(adi);
				personel.setSoyadi(soyadi);
				liste.add(personel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
}
