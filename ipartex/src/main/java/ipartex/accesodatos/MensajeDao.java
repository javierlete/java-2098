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

public class MensajeDao {
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver");
		}
	}
	
	private static final String URL = "jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\git\\java-2098\\ipartex\\bdd\\ipartex.db";
	private static final String SQL_SELECT = """
			SELECT m.id AS m_id, m.fecha AS m_fecha, m.texto AS m_texto,
			        u.id AS u_id, u.nombre AS u_nombre, u.email AS u_email, u.password AS u_password,
			        COUNT(um.usuarios_id) AS m_lesgusta
			FROM mensajes m
			JOIN usuarios u ON u.id = m.usuario_id
			JOIN usuarios_lesgusta_mensajes um ON m.id = um.mensajes_id
			GROUP BY m.id
			""";

	public static ArrayList<Mensaje> getMensajes() {
		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			var mensajes = new ArrayList<Mensaje>();
			
			Usuario usuario;
			Mensaje mensaje;
			
			while(rs.next()) {
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_nombre"), rs.getString("u_email"), rs.getString("u_password"));
				mensaje = new Mensaje(rs.getLong("m_id"), usuario, LocalDateTime.parse(rs.getString("m_fecha"), Mensaje.FORMATEADOR_FECHA), rs.getString("m_texto"), rs.getLong("m_lesgusta"));
				
				mensajes.add(mensaje);
			}
			
			return mensajes;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
}
