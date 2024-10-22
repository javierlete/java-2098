package poo.pruebas;

import java.math.BigDecimal;

import poo.pojos.Almacen;
import poo.pojos.Producto;

public class AlmacenPruebas {
	public static void main(String[] args) {
		Almacen bilbao = new Almacen("Bilbao");

		bilbao.meterProducto(new Producto("Teclado", new BigDecimal("34.56")));
		bilbao.meterProducto(new Producto("Alfombrilla de ratón", new BigDecimal("4.99")));

		System.out.println(bilbao);

		System.out.println(bilbao.getNombre());

		for (Producto p : bilbao.getProductos()) {
			System.out.println(p.getNombre() + ": " + p.getPrecio());
		}

		Producto productoBuscado = bilbao.getProductoPorId(1L);

		if (productoBuscado != null) {
			System.out.println(productoBuscado);
		} else {
			System.out.println("No se ha encontrado el producto");
		}
		
		System.out.println(bilbao);
		
		bilbao.eliminarProducto(1L);
		
		System.out.println(bilbao);
		
		bilbao.modificarProducto(new Producto(2L, "MODIFICADO", new BigDecimal("4321.12")));
		
		System.out.println(bilbao);
	}
}
