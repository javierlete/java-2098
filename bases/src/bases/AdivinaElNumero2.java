package bases;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero2 {
	private static final ArrayList<Integer> puntuaciones = new ArrayList<Integer>();
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Elegir el rango de números
		// TODO Número máximo de intentos
		// TODO Poder poner tu nombre en las puntuaciones

		do {
			int pensado = new Random().nextInt(1, 10);
			int intentos = 0;
			
			int introducido;

			do {
				introducido = pedirNumero();

				intentos++;

				mostrarResultado(pensado, intentos, introducido);
			} while (pensado != introducido);

			puntuaciones.add(intentos);
			
		} while (pedirOtraPartida());

		cierre();

		sc.close();
	}

	private static int pedirNumero() {
		int introducido;
		System.out.print("Dime un número: ");
		introducido = sc.nextInt();
		sc.nextLine();
		return introducido;
	}

	private static void mostrarResultado(int pensado, int intentos, int introducido) {
		if (pensado > introducido) {
			System.out.println("ES MAYOR");
		} else if (pensado < introducido) {
			System.out.println("Es menor");
		} else {
			System.out.println("HAS ACERTADO");
			System.out.println("EFECTIVAMENTE EL NÚMERO ERA EL " + pensado);
			System.out.println("Has necesitado " + intentos + " intentos");
		}
	}

	private static boolean pedirOtraPartida() {
		boolean otraPartida;
		System.out.print("¿Otra partida? (s/N): ");
		String otra = sc.nextLine();
		otraPartida = otra.equals("s");
		return otraPartida;
	}

	private static void cierre() {
		System.out.print("Puntuaciones: ");

		puntuaciones.sort((a, b) -> Integer.compare(a, b));

		System.out.println(puntuaciones);

		System.out.println("Gracias por jugar");
	}
}
