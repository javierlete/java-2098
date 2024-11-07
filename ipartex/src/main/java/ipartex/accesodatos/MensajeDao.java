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

import static ipartex.accesodatos.Globales.URL;

public class MensajeDao {
	private static final String SQL_SELECT = """
			SELECT m.id AS m_id, m.fecha AS m_fecha, m.texto AS m_texto,
			        u.id AS u_id, u.nombre AS u_nombre, u.email AS u_email, u.password AS u_password,
			        COUNT(um.usuarios_id) AS m_lesgusta
			FROM mensajes m
			LEFT JOIN usuarios u ON u.id = m.usuario_id
			LEFT JOIN usuarios_lesgusta_mensajes um ON m.id = um.mensajes_id
			GROUP BY m.id
			ORDER BY m.fecha DESC, m.id DESC
			""";
	private static final String SQL_INSERT = "INSERT INTO mensajes (usuario_id, fecha, texto) VALUES (?,?,?)";

	public static ArrayList<Mensaje> getMensajes() {
		try (Connection con = DriverManager.getConnection(URL);
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

	public static void insertar(Mensaje mensaje) {
		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {

			pst.setLong(1, mensaje.getUsuario().getId());
			pst.setString(2, mensaje.getFechaFormateada());
			pst.setString(3, mensaje.getTexto());

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
}
