package ipartex.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ipartex.modelos.Mensaje;
import ipartex.modelos.Usuario;

import static ipartex.accesodatos.Globales.*;

public class MensajeDao {
	private static final String SQL_SELECT_CON_BORRADOS = """
			SELECT m.id AS m_id, m.fecha AS m_fecha, m.texto AS m_texto, m.borrado AS m_borrado,
			        u.id AS u_id, u.nombre AS u_nombre, u.email AS u_email, u.password AS u_password,
			        COUNT(um.usuarios_id) AS m_lesgusta
			FROM mensajes m
			LEFT JOIN usuarios u ON u.id = m.usuario_id
			LEFT JOIN usuarios_lesgusta_mensajes um ON m.id = um.mensajes_id
			GROUP BY m.id
			ORDER BY m.fecha DESC, m.id DESC
			""";
	private static final String SQL_SELECT = """
			SELECT m.id AS m_id, m.fecha AS m_fecha, m.texto AS m_texto,
			        u.id AS u_id, u.nombre AS u_nombre, u.email AS u_email, u.password AS u_password,
			        COUNT(um.usuarios_id) AS m_lesgusta
			FROM mensajes m
			LEFT JOIN usuarios u ON u.id = m.usuario_id
			LEFT JOIN usuarios_lesgusta_mensajes um ON m.id = um.mensajes_id
			WHERE m.borrado = FALSE
			GROUP BY m.id
			ORDER BY m.fecha DESC, m.id DESC
			""";
	private static final String SQL_INSERT = "INSERT INTO mensajes (usuario_id, fecha, texto) VALUES (?,?,?)";

	private static final String SQL_SELECT_LEGUSTA = """
			SELECT * 
			FROM usuarios_lesgusta_mensajes 
			WHERE usuarios_id=? AND mensajes_id=?
			""";
	
	private static final String SQL_INSERT_LEGUSTA = "INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (?,?)";
	private static final String SQL_DELETE_LEGUSTA = "DELETE FROM usuarios_lesgusta_mensajes WHERE usuarios_id=? AND mensajes_id=?";
	private static final String SQL_DELETE = "UPDATE mensajes SET borrado=TRUE WHERE usuario_id=? AND id=? AND borrado=FALSE";
	private static final String SQL_RECUPERAR = "UPDATE mensajes SET borrado=FALSE WHERE id=? AND borrado=TRUE";
	
	public static ArrayList<Mensaje> getMensajes() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			var mensajes = new ArrayList<Mensaje>();

			Usuario usuario;
			Mensaje mensaje;

			while (rs.next()) {
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_nombre"), rs.getString("u_email"),
						rs.getString("u_password"));
				mensaje = new Mensaje(rs.getLong("m_id"), usuario,
						LocalDateTime.parse(rs.getString("m_fecha"), Mensaje.FORMATEADOR_FECHA),
						rs.getString("m_texto"), rs.getLong("m_lesgusta"));

				mensajes.add(mensaje);
			}

			return mensajes;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static ArrayList<Mensaje> getMensajesConBorrados() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_CON_BORRADOS);
				ResultSet rs = pst.executeQuery()) {
			var mensajes = new ArrayList<Mensaje>();

			Usuario usuario;
			Mensaje mensaje;

			while (rs.next()) {
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_nombre"), rs.getString("u_email"),
						rs.getString("u_password"));
				
				mensaje = new Mensaje(rs.getLong("m_id"), usuario,
						LocalDateTime.parse(rs.getString("m_fecha"), Mensaje.FORMATEADOR_FECHA),
						rs.getString("m_texto"), rs.getLong("m_lesgusta"));

				mensaje.setBorrado(rs.getBoolean("m_borrado"));
				
				mensajes.add(mensaje);
			}

			return mensajes;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static void insertar(Mensaje mensaje) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {

			pst.setLong(1, mensaje.getUsuario().getId());
			pst.setString(2, mensaje.getFechaFormateada());
			pst.setString(3, mensaje.getTexto());

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static boolean legusta(Long idUsuario, Long idMensaje) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_LEGUSTA);
				) {
			pst.setLong(1, idUsuario);
			pst.setLong(2, idMensaje);
			
			ResultSet rs = pst.executeQuery();
			
			return rs.next();
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static void agregarMegusta(Long idUsuario, Long idMensaje) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT_LEGUSTA);
				) {
			pst.setLong(1, idUsuario);
			pst.setLong(2, idMensaje);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static void quitarMegusta(Long idUsuario, Long idMensaje) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_LEGUSTA);
				) {
			pst.setLong(1, idUsuario);
			pst.setLong(2, idMensaje);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static void borrar(Long idUsuario, Long idMensaje) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				) {
			pst.setLong(1, idUsuario);
			pst.setLong(2, idMensaje);
			
			int numeroRegistrosModificados = pst.executeUpdate();
			
			if(numeroRegistrosModificados == 0) {
				throw new RuntimeException("No se ha borrado ningún registro");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static void recuperar(Long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_RECUPERAR);
				) {
			pst.setLong(1, id);
			
			int numeroRegistrosModificados = pst.executeUpdate();
			
			if(numeroRegistrosModificados == 0) {
				throw new RuntimeException("No se ha recuperado ningún registro");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
}
