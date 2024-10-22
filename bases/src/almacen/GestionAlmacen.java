package almacen;

import static bibliotecas.Consola.*;

import poo.pojos.Almacen;
import poo.pojos.Producto;

public class GestionAlmacen {
	private static final String FORMATO_LINEA = "%4s %-20s %10s";
	private static final int SALIR = 0;
	private static final Almacen almacen = new Almacen("GestionAlmacen");

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = seleccionarOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void mostrarMenu() {
		pl("""

				MENÚ
				====
				1. LISTADO
				2. BUSCAR POR ID
				3. INSERTAR
				4. MODIFICAR
				5. BORRAR

				0. SALIR

					""");
	}

	private static int seleccionarOpcion() {
		return pedirEntero("Selecciona una opción");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			listado();
			break;
		case 2:
			buscarPorId();
			break;
		case 3:
			insertar();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 0:
			pl("Gracias por usar la aplicación");
			break;
		default:
			pl("No reconozco esa opción");
		}
	}

	private static void listado() {
		pl(String.format(FORMATO_LINEA, "ID", "NOMBRE", "PRECIO"));
		pl(String.format(FORMATO_LINEA, "==", "======", "======"));
		
		for (Producto p : almacen.getProductos()) {
			mostrarLineaProducto(p);
		}
	}

	private static void mostrarLineaProducto(Producto p) {
		pl(String.format(FORMATO_LINEA, p.getId(), p.getNombre(), String.format("%10.2f €", p.getPrecio())));
	}

	private static void buscarPorId() {
		Long id = pedirLong("Dime el id por el que buscar");

		Producto producto = almacen.getProductoPorId(id);

		mostrarFichaProducto(producto);
	}

	private static void mostrarFichaProducto(Producto producto) {
		if (producto != null) {
			pl(producto.toString());
		} else {
			pl("No se ha encontrado el producto");
		}
	}

	private static void insertar() {
		String nombre = pedirTexto("Dame el nombre del producto", REQUERIDO);
		Double precio = pedirDouble("Dame el precio del producto", Producto.PRECIO_MINIMO);

		Producto producto = new Producto(nombre, precio);

		almacen.meterProducto(producto);
	}

	private static void modificar() {
		Long id = pedirLong("Dime el id del producto a cambiar");
		String nombre = pedirTexto("Dame el nombre del producto", REQUERIDO);
		Double precio = pedirDouble("Dame el precio del producto", Producto.PRECIO_MINIMO);

		Producto producto = new Producto(id, nombre, precio);

		almacen.modificarProducto(producto);

	}

	private static void borrar() {
		Long id = pedirLong("Dime el id del producto a borrar");

		almacen.eliminarProducto(id);
	}
}
