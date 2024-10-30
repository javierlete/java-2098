package ipartube.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ipartube.modelos.Autor;

public class AutorDao {
	static {
		try {
			System.out.println("Cargando driver");
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
	}
	
	private static final String sqlSelectId = "SELECT * FROM autores WHERE id=";
	
	public static Autor obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(Globales.url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelectId + id)) {
			Autor autor = null;
			
			if(rs.next()) {
				autor = new Autor(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));
			}
			
			return autor;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
	
}
