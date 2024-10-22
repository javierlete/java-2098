package bibliotecas;

import java.math.BigDecimal;
import java.util.Scanner;

public class Consola {
	public static final boolean REQUERIDO = true;
	private static final Scanner SC = new Scanner(System.in);

	public static void pl() {
		System.out.println();
	}

	public static void pl(String mensaje) {
		System.out.println(mensaje);
	}

	public static void p(String mensaje) {
		System.out.print(mensaje);
	}

	public static int pedirEntero() {
		String sEntero = SC.nextLine();
		int entero = Integer.parseInt(sEntero);
		return entero;
	}

	public static int pedirEntero(String mensaje) {
		try {
			p(mensaje + ": ");

			return pedirEntero();
		} catch (NumberFormatException e) {
			pl("El texto recibido no es un número entero");
			return pedirEntero(mensaje);
		}
	}

	public static int pedirEntero(String mensaje, int minimo) {
		int entero = pedirEntero(mensaje);

		if (entero >= minimo) {
			return entero;
		}

		pl("El número introducido es menor que el " + minimo);
		return pedirEntero(mensaje, minimo);
	}

	public static long pedirLong() {
		String sLong = SC.nextLine();
		long largo = Long.parseLong(sLong);
		return largo;
	}
	
	public static long pedirLong(String mensaje) {
		try {
			p(mensaje + ": ");
			
			return pedirLong();
		} catch (NumberFormatException e) {
			pl("El texto recibido no es un número entero largo");
			return pedirLong(mensaje);
		}
	}
	
	public static long pedirLong(String mensaje, long minimo) {
		long enteroLargo = pedirLong(mensaje);
		
		if (enteroLargo >= minimo) {
			return enteroLargo;
		}
		
		pl("El número introducido es menor que el " + minimo);
		return pedirLong(mensaje, minimo);
	}
	
	public static double pedirDouble() {
		String sDouble = SC.nextLine();
		double doble = Double.parseDouble(sDouble);
		return doble;
	}
	
	public static double pedirDouble(String mensaje) {
		try {
			p(mensaje + ": ");
			
			return pedirDouble();
		} catch (NumberFormatException e) {
			pl("El texto recibido no es un número con decimales");
			return pedirDouble(mensaje);
		}
	}
	
	public static double pedirDouble(String mensaje, double minimo) {
		double doble = pedirDouble(mensaje);
		
		if (doble >= minimo) {
			return doble;
		}
		
		pl("El número introducido es menor que el " + minimo);
		return pedirDouble(mensaje, minimo);
	}
	public static BigDecimal pedirBigDecimal() {
		String sDecimal = SC.nextLine();
		BigDecimal decimal = new BigDecimal(sDecimal);
		return decimal;
	}
	
	public static BigDecimal pedirBigDecimal(String mensaje) {
		try {
			p(mensaje + ": ");
			
			return pedirBigDecimal();
		} catch (NumberFormatException e) {
			pl("El texto recibido no es un número con decimales");
			return pedirBigDecimal(mensaje);
		}
	}
	
	public static BigDecimal pedirBigDecimal(String mensaje, BigDecimal minimo) {
		BigDecimal decimal = pedirBigDecimal(mensaje);
		
		if (decimal.compareTo(minimo) >= 0) {
			return decimal;
		}
		
		pl("El número introducido es menor que el " + minimo);
		return pedirBigDecimal(mensaje, minimo);
	}

	public static String pedirTexto(String mensaje) {
		p(mensaje + ": ");

		return SC.nextLine();
	}
	
	public static String pedirTexto(String mensaje, boolean requerido) {
		String texto;
		
		do {
			texto = pedirTexto(mensaje + " (requerido)");
			
			if(texto.isBlank()) {
				pl("Debes introducir algo en este texto");
			}
		} while (requerido && texto.isBlank());
		
		return texto;
	}
		
}
