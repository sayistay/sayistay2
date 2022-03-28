package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/personel")
public class PersonelServlet extends HttpServlet {
	private static final long serialVersionUID = 5999710141201379506L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

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
				out.println("Id: " + id + ", Adi: " + adi + ", Soyadi: " + soyadi);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
