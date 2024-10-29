package poo.pojos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Almacen {
	private static final String url = "jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\git\\java-2098\\ejemploweb\\bdd\\ejemploweb.db";
	private static final String user = "";
	private static final String pass = "";

	// VARIABLES DE INSTANCIA
	private String nombre;
	private ArrayList<Producto> productos = new ArrayList<Producto>();

	// "CONSTRUCTOR ESTÁTICO"
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("NO SE HA ENCONTRADO EL DRIVER");
		}
	}

	// CONSTRUCTORES
	public Almacen(String nombre) {
		super();
		this.nombre = nombre;
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getProductos() {

		String sql = "SELECT * FROM productos";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			Producto producto = null;

			productos.clear();
			
			while (rs.next()) {
				producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"));
				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new RuntimeException("Ha fallado la consulta");
		}
	}

	// MÉTODOS DE INSTANCIA
	public Producto getProductoPorId(Long id) {
		throw new UnsupportedOperationException("NO ESTÁ IMPLEMENTADO");
	}

	public Producto meterProducto(Producto producto) {
		String sql = "INSERT INTO productos (nombre, precio) VALUES ('%s', %s)";

		try (Connection con = DriverManager.getConnection(url, user, pass); Statement st = con.createStatement()) {
			st.executeUpdate(String.format(sql, producto.getNombre(), producto.getPrecio()));

			return producto;
		} catch (SQLException e) {
			throw new RuntimeException("Ha fallado la consulta");
		}
	}

	public Producto modificarProducto(Producto producto) {
		throw new UnsupportedOperationException("NO ESTÁ IMPLEMENTADO");
	}

	public void eliminarProducto(Long id) {
		throw new UnsupportedOperationException("NO ESTÁ IMPLEMENTADO");
	}
}
