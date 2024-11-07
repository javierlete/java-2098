package ipartex.accesodatos;

import static ipartex.accesodatos.Globales.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ipartex.modelos.Usuario;

public class UsuarioDao {
	private static final String SQL_INSERT = "INSERT INTO usuarios (nombre, email, password) VALUES (?,?,?)";
	private static final String SQL_SELECT_EMAIL = "SELECT * FROM usuarios WHERE email=?";

	public static void insertar(Usuario usuario) {
		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getPassword());

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido ejecutar la consulta", e);
		}
	}

	public static Usuario buscarPorEmail(String email) {
		try (Connection con = DriverManager.getConnection(URL);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL)) {
			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();

			Usuario usuario = null;
			
			if (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("password"));
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido ejecutar la consulta", e);
		}
	}
}
