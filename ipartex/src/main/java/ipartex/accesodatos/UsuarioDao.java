package ipartex.accesodatos;

import static ipartex.accesodatos.Globales.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ipartex.modelos.Usuario;

public class UsuarioDao {
	private static final String SQL_INSERT = "INSERT INTO usuarios (nombre, email, password) VALUES (?,?,?)";;

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
}
