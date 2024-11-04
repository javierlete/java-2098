package ipartube.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	private static final String sqlSelect = "SELECT * FROM autores";
	private static final String sqlSelectId = "SELECT * FROM autores WHERE id=";
	private static final String sqlSelectIdVideos = "SELECT * FROM videos WHERE autor_id=";
	private static final String sqlInsert = "INSERT INTO autores (email, password, nombre, descripcion) VALUES (?,?,?,?)";
	
	public static ArrayList<Autor> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(Globales.url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelect)) {
			ArrayList<Autor> autores = new ArrayList<>();
			
			Autor autor = null;
			
			while(rs.next()) {
				autor = new Autor(rs.getLong("id"), rs.getString("email"), rs.getString("password"), rs.getString("nombre"), rs.getString("descripcion"));
				autores.add(autor);
			}
			
			return autores;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static Autor obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(Globales.url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelectId + id)) {
			Autor autor = null;
			
			if(rs.next()) {
				autor = new Autor(rs.getLong("id"), rs.getString("email"), rs.getString("password"), rs.getString("nombre"), rs.getString("descripcion"));
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

	public static void insertar(Autor autor) {
		try (Connection con = DriverManager.getConnection(Globales.url);
				PreparedStatement pst = con.prepareStatement(sqlInsert);
				) {

			pst.setString(1, autor.getEmail());
			pst.setString(2, autor.getPassword());
			pst.setString(3, autor.getNombre());
			pst.setString(4, autor.getDescripcion());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
}
