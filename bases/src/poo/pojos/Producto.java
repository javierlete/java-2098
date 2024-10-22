package poo.pojos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Producto {
	// CONSTANTES
	public static final int NUMERO_DECIMALES = 2;
	public static final BigDecimal PRECIO_MINIMO = BigDecimal.ZERO;

	// VARIABLES DE INSTANCIA
	private Long id;
	private String nombre;
	private BigDecimal precio;

	// CONSTRUCTORES
	public Producto(Long id, String nombre, BigDecimal precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}

	public Producto(String nombre, BigDecimal precio) {
		this(null, nombre, precio);
	}

	// GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("No se permiten nombres vacíos o nulos");
		}
		
		this.nombre = nombre.trim();
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		if (precio.compareTo(PRECIO_MINIMO) < 0) {
			throw new IllegalArgumentException("No se admiten precios negativos");
		}
		
<<<<<<< HEAD
		this.precio = precio.setScale(NUMERO_DECIMALES, RoundingMode.HALF_UP);
=======
		this.precio = precio.setScale(2, RoundingMode.HALF_UP);
>>>>>>> branch 'master' of https://github.com/javierlete/java-2098
	}

	// TOSTRING()
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
