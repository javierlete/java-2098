package ipartube.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ipartube.modelos.Autor;
import ipartube.modelos.Video;

public class VideoDao {
	static {
		try {
			System.out.println("Cargando driver");
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
	}
	
	private static final String sqlSelect = """
			SELECT v.id AS v_id, v.nombre AS v_nombre, v.descripcion AS v_descripcion, v.url AS v_url
			    , a.id AS a_id, a.nombre AS a_nombre, a.descripcion AS a_descripcion
			FROM videos v
			JOIN autores a ON v.autor_id = a.id
			"""; // "SELECT * FROM videos_autores"

	public static ArrayList<Video> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(Globales.url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelect)) {
			Video video = null;
			Autor autor = null;
			
			ArrayList<Video> videos = new ArrayList<>();
			
			while(rs.next()) {
				autor = new Autor(rs.getLong("a_id"), rs.getString("a_nombre"), rs.getString("a_descripcion"));
				video = new Video(rs.getLong("v_id"), rs.getString("v_nombre"), rs.getString("v_descripcion"), rs.getString("v_url"), autor);

				videos.add(video);
			}
			
			return videos;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
}
