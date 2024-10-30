package ipartube.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ipartube.modelos.Video;

public class VideoDao {
	private static final String url = "jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\git\\java-2098\\IparTube\\bdd\\ipartube.db";
	
	private static final String sqlSelect = "SELECT * FROM videos";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
	}
	
	public static ArrayList<Video> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelect)) {
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
