package poo.pojos;

public class Producto {
	// CONSTANTES
	public static final double PRECIO_MINIMO = 0.0;

	// VARIABLES DE INSTANCIA
	private Long id;
	private String nombre;
	private Double precio;

	// CONSTRUCTORES
	public Producto(Long id, String nombre, Double precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}

	public Producto(String nombre, Double precio) {
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		if (precio < PRECIO_MINIMO) {
			throw new IllegalArgumentException("No se admiten precios negativos");
		}
		
		this.precio = precio;
	}

	// TOSTRING()
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
