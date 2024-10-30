package ipartube.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ipartube.modelos.Autor;
import ipartube.modelos.Video;

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
	private static final String sqlSelectIdVideos = "SELECT * FROM videos WHERE autor_id=";
	
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
	
	public static ArrayList<Video> obtenerPorIdVideos(Long id) {
		try (Connection con = DriverManager.getConnection(Globales.url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelectIdVideos + id)) {
			Video video = null;
			
			ArrayList<Video> videos = new ArrayList<>();
			
			while(rs.next()) {
				video = new Video(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("url"), null);

				videos.add(video);
			}
			
			return videos;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
}