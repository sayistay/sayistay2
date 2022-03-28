package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBBase {
	private Connection connection;

	protected Connection getConnection() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5433/sayistay", "postgres",
					"postgres");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void close(PreparedStatement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void close(ResultSet rs, PreparedStatement stmt) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	}
}
