package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBBase {
	private static ThreadLocal<Connection> connLocal = new ThreadLocal<>();
	private static ThreadLocal<List<PreparedStatement>> stmtListLocal = new ThreadLocal<>();
	private static ThreadLocal<List<ResultSet>> rsListLocal = new ThreadLocal<>();

	protected Connection getConnection() {
		try {
			if (connLocal.get() == null) {
				System.out.println("Connection aliniyor.");
				MyConnection myConnection = new MyConnection(DriverManager
						.getConnection("jdbc:postgresql://localhost:5433/sayistay",
								"postgres", "postgres"));
				connLocal.set(myConnection);
			} else {
				System.out
						.println("Daha önce alınan connection tekrar kullanılıyor.");
			}
			return connLocal.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static List<ResultSet> getRsListe() {
		List<ResultSet> sonuc = rsListLocal.get();
		if (sonuc == null) {
			sonuc = new ArrayList<ResultSet>();
			rsListLocal.set(sonuc);
		}
		return sonuc;
	}

	public static void addResultSet(ResultSet rs) {
		getRsListe().add(rs);
	}

	public static void addStatement(PreparedStatement stmt) {
		getStmtListe().add(stmt);
	}

	private static List<PreparedStatement> getStmtListe() {
		List<PreparedStatement> sonuc = stmtListLocal.get();
		if (sonuc == null) {
			sonuc = new ArrayList<PreparedStatement>();
			stmtListLocal.set(sonuc);
		}
		return sonuc;
	}

	public static void closeConnection() {
		try {
			closeResultSets();
			closeStatements();
			System.out.println("Connection kapatiliyor.");
			connLocal.get().close();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	private static void closeStatements() {
		List<PreparedStatement> stmts = stmtListLocal.get();
		if (stmts != null) {
			stmts.forEach(s -> {
				try {
					System.out.println("Statement kapatiliyor.");
					s.close();
				} catch (SQLException e) {
					// e.printStackTrace();
				}
			});
		}

	}

	private static void closeResultSets() {
		List<ResultSet> rs = rsListLocal.get();
		if (rs != null) {
			rs.forEach(r -> {
				try {
					System.out.println("ResultSet kapatiliyor.");
					r.close();
				} catch (SQLException e) {
					// e.printStackTrace();
				}
			});
		}

	}

	protected void close(PreparedStatement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	protected void close(ResultSet rs, PreparedStatement stmt) {
		try {
			rs.close();
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			close(stmt);
		}
	}
}
