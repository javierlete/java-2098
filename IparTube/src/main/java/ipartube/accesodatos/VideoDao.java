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

public class VideoDao {
	private static final boolean ADMIN = true;

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
			    , a.id AS a_id, a.email AS a_email, a.password AS a_password, a.nombre AS a_nombre, a.descripcion AS a_descripcion
			FROM videos v
			JOIN autores a ON v.autor_id = a.id
			"""; // "SELECT * FROM videos_autores"

	private static final String sqlSelectId = sqlSelect + " WHERE v_id=";
	private static final String sqlInsert = "INSERT INTO videos (nombre, descripcion, url, autor_id) VALUES (?, ?, ?, ?)";
	private static final String sqlUpdateAdmin = "UPDATE videos SET nombre=?, descripcion=?, url=?, autor_id=? WHERE id=?";
	private static final String sqlUpdateUsuario = "UPDATE videos SET nombre=?, descripcion=?, url=? WHERE autor_id=? AND id=?";
	private static final String sqlDeleteAdmin = "DELETE FROM videos WHERE id=?";
	private static final String sqlDeleteUsuario = "DELETE FROM videos WHERE id=? AND autor_id=?";

	public static ArrayList<Video> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(Globales.url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelect)) {
			Video video = null;
			Autor autor = null;

			ArrayList<Video> videos = new ArrayList<>();

			while (rs.next()) {
				autor = new Autor(rs.getLong("a_id"), rs.getString("a_email"), rs.getString("a_password"),
						rs.getString("a_nombre"), rs.getString("a_descripcion"));
				video = new Video(rs.getLong("v_id"), rs.getString("v_nombre"), rs.getString("v_descripcion"),
						rs.getString("v_url"), autor);

				videos.add(video);
			}

			return videos;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static Video obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(Globales.url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelectId + id)) {
			Video video = null;
			Autor autor = null;

			if (rs.next()) {
				autor = new Autor(rs.getLong("a_id"), rs.getString("a_email"), rs.getString("a_password"),
						rs.getString("a_nombre"), rs.getString("a_descripcion"));
				video = new Video(rs.getLong("v_id"), rs.getString("v_nombre"), rs.getString("v_descripcion"),
						rs.getString("v_url"), autor);
			}

			return video;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static void insertar(Video video) {
		try (Connection con = DriverManager.getConnection(Globales.url);
				PreparedStatement pst = con.prepareStatement(sqlInsert);) {
			pst.setString(1, video.getNombre());
			pst.setString(2, video.getDescripcion());
			pst.setString(3, video.getUrl());
			pst.setLong(4, video.getAutor().getId());

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static void modificar(Video video) {
		modificar(video, ADMIN);
	}

	public static void modificar(Video video, boolean admin) {
		String sqlUpdate = admin ? sqlUpdateAdmin : sqlUpdateUsuario;
		
		try (Connection con = DriverManager.getConnection(Globales.url);
				PreparedStatement pst = con.prepareStatement(sqlUpdate);) {
			pst.setString(1, video.getNombre());
			pst.setString(2, video.getDescripcion());
			pst.setString(3, video.getUrl());
			pst.setLong(4, video.getAutor().getId());
			pst.setLong(5, video.getId());

			int numRegistrosModificados = pst.executeUpdate();
			
			if(numRegistrosModificados == 0) {
				throw new RuntimeException("No se ha podido modificar el registro");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static void borrar(Long id) {
		borrar(id, null);
	}

	public static void borrar(Long id, Long autorId) {
		String sqlDelete = autorId == null ? sqlDeleteAdmin : sqlDeleteUsuario;
		
		try (Connection con = DriverManager.getConnection(Globales.url);
				PreparedStatement pst = con.prepareStatement(sqlDelete);) {
			pst.setLong(1, id);

			if(autorId != null) {
				pst.setLong(2, autorId);
			}
			
			int numRegistrosModificados = pst.executeUpdate();
			
			if(numRegistrosModificados == 0) {
				throw new RuntimeException("Ha habido un error en el borrado");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
}
