package bases;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero2 {
	public static void main(String[] args) {
		// TODO Elegir el rango de números
		// TODO Número máximo de intentos
		// TODO Poder poner tu nombre en las puntuaciones
		var puntuaciones = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);

		boolean otraPartida;

		do {
			int pensado = new Random().nextInt(1, 10);
			int intentos = 0;
			int introducido;

			do {
				introducido = pedirNumero(sc);

				intentos++;

				mostrarResultado(puntuaciones, pensado, intentos, introducido);
			} while (pensado != introducido);

			otraPartida = pedirOtraPartida(sc);
		} while (otraPartida);

		cierre(puntuaciones);

		sc.close();
	}

	private static void cierre(ArrayList<Integer> puntuaciones) {
		System.out.print("Puntuaciones: ");

		puntuaciones.sort((a, b) -> Integer.compare(a, b));

		System.out.println(puntuaciones);

		System.out.println("Gracias por jugar");
	}

	private static boolean pedirOtraPartida(Scanner sc) {
		boolean otraPartida;
		System.out.print("¿Otra partida? (s/N): ");
		String otra = sc.nextLine();
		otraPartida = otra.equals("s");
		return otraPartida;
	}

	private static void mostrarResultado(ArrayList<Integer> puntuaciones, int pensado, int intentos, int introducido) {
		if (pensado > introducido) {
			System.out.println("ES MAYOR");
		} else if (pensado < introducido) {
			System.out.println("Es menor");
		} else {
			System.out.println("HAS ACERTADO");
			System.out.println("EFECTIVAMENTE EL NÚMERO ERA EL " + pensado);
			System.out.println("Has necesitado " + intentos + " intentos");

			puntuaciones.add(intentos);
		}
	}

	private static int pedirNumero(Scanner sc) {
		int introducido;
		System.out.print("Dime un número: ");
		introducido = sc.nextInt();
		sc.nextLine();
		return introducido;
	}
}
