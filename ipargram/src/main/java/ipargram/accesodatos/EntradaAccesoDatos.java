package ipargram.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import ipargram.modelos.Entrada;

public class EntradaAccesoDatos {
	private static final String URL = "jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\git\\java-2098\\ipargram\\bdd\\ipargram.db";
	private static final String USER = "";
	private static final String PASS = "";

	private static final String SQL_SELECT = "SELECT * FROM entradas";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_INSERT = "INSERT INTO entradas (titulo, fecha_hora) VALUES (?,?)";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
	}

	public static ArrayList<Entrada> obtenerTodas() {
		var entradas = new ArrayList<Entrada>();

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			Entrada entrada;

			while (rs.next()) {
				entrada = new Entrada(rs.getLong("id"), rs.getString("titulo"),
						LocalDateTime.parse(rs.getString("fecha_hora")));

				entradas.add(entrada);
			}

			return entradas;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}

	public static Entrada obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {

			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			Entrada entrada = null;

			if (rs.next()) {
				entrada = new Entrada(rs.getLong("id"), rs.getString("titulo"),
						LocalDateTime.parse(rs.getString("fecha_hora")));
			}

			return entrada;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
	
	public static Entrada insertar(Entrada entrada) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, entrada.getTitulo());
			pst.setString(2, entrada.getFechaHora().format(DateTimeFormatter.ISO_DATE_TIME));

			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			rs.next();
			
			entrada.setId(rs.getLong(1));
			
			return entrada;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta", e);
		}
	}
}
