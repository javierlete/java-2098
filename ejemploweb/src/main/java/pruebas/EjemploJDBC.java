package pruebas;

import java.sql.*;

public class EjemploJDBC {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlite:bdd/ejemploweb.db";
		String user = "";
		String pass = "";

		String sql = "SELECT * FROM productos";
		String sqlInsert = "INSERT INTO productos (nombre, precio) VALUES ('NUEVO', 1234.56)";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		st.executeUpdate(sqlInsert);

		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			System.out.printf("%3s %-20s %10s\n", rs.getInt("id"), rs.getString("nombre"), rs.getBigDecimal("precio"));
		}
	}
}
