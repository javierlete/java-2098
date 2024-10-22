package poo.pojos;

import java.util.ArrayList;

public class Almacen {
	// VARIABLES DE INSTANCIA
	private String nombre;
	
	private ArrayList<Producto> productos = new ArrayList<Producto>();

	// CONSTRUCTORES
	public Almacen(String nombre) {
		super();
		this.nombre = nombre;
		
		meterProducto(new Producto("Portátil", 1234.21789));
		meterProducto(new Producto("Teclado", 123.363456));
		meterProducto(new Producto("Ratón", 12.5112314));
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	// MÉTODOS DE INSTANCIA
	public Producto getProductoPorId(Long id) {
		for(Producto p: productos) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}
	
	public Producto meterProducto(Producto producto) {
		Long ultimoId = 0L;
		
		for(Producto p: productos) {
			if(p.getId() > ultimoId) {
				ultimoId = p.getId();
			}
		}
		
		producto.setId(ultimoId + 1L);
		
		productos.add(producto);
		
		return producto;
	}
	
	public Producto modificarProducto(Producto producto) {
		for(int i = 0; i < productos.size(); i++) {
			if(producto.getId() == productos.get(i).getId()) {
				productos.set(i, producto);
				
				return producto;
			}
		}
		
		throw new IllegalArgumentException("No tengo un producto con ese Id");
	}
	
	public void eliminarProducto(Long id) {
		for(Producto p: productos) {
			if(p.getId() == id) {
				productos.remove(p);
				return;
			}
		}
		
		throw new IllegalArgumentException("No tengo un producto con ese Id");
	}
	
	// TOSTRING()
	@Override
	public String toString() {
		return "Almacen [nombre=" + nombre + ", productos=" + productos + "]";
	}
}
