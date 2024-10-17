package bibliotecas;

import java.util.Scanner;

public class Consola {
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

	public static String pedirTexto(String mensaje) {
		p(mensaje + ": ");

		return SC.nextLine();
	}
}
