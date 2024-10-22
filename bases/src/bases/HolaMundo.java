/**
 * Paquete donde vamos a poner clases introductorias
 */
package bases;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Clase de ejemplo básica
 */
public class HolaMundo {
	/**
	 * Método de inicio cuando arrancas la aplicación
	 * 
	 * @param args argumentos de la línea de consola
	 */
	public static void main(String[] args) {
		/*
		 * Ejemplo básico de uso del lenguaje Java
		 */
		System.out.println("Hola desde java-2098");

		double d1; // Declaración de variable

		d1 = 0.1; // Asignación de variable

		double d2 = 0.2; // Inicialización y declaración de variable

		System.out.println(d1 + d2); // d1 + d2 es una expresión

		BigDecimal b1 = new BigDecimal("0.1");
		BigDecimal b2 = new BigDecimal("0.2");
		
		System.out.println(b1.add(b2));
		
		String nombre = "Javier";

		System.out.println(nombre);

		nombre = "Pepe";

		System.out.println(nombre);

		LocalDateTime ahora = LocalDateTime.now();

		System.out.println(ahora);

		System.out.println(6 ^ 3); // NO es una potencia
		System.out.println(Math.pow(6, 3)); // Este SÍ
		
		System.out.println(6 > 3);
		
		int x = 4;
		
		System.out.println(1 <= x && x <= 10);
		
		System.out.println(++x);
		System.out.println(x);
	}
}
