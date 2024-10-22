package poo.pruebas;

import java.math.BigDecimal;
import java.util.ArrayList;

import poo.pojos.Producto;

public class ProductoPruebas {
	public static void main(String[] args) {
		Producto p = new Producto(1L, "Portátil", new BigDecimal("1234.56"));
		
		System.out.println(p.toString());
		
		System.out.println(p.getPrecio());
		
		p.setNombre("Portátil HP");
		
		System.out.println(p);
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		productos.add(p);
		
		Producto nuevo = new Producto("Ratón", new BigDecimal("12.34"));
		
		Long ultimoId = 0L;
		
		for(Producto producto: productos) {
			if(producto.getId() > ultimoId) {
				ultimoId = producto.getId();
			}
		}
		
		nuevo.setId(ultimoId + 1L);
		
		productos.add(nuevo);
		
		for(Producto producto: productos) {
			System.out.println(producto);
		}
	}
}
