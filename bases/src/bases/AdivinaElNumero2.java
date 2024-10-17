package bases;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static bibliotecas.Consola.*;

public class AdivinaElNumero2 {
	private static final int MINIMO_INTENTOS_MAXIMO = 1;
	private static final ArrayList<Integer> puntuaciones = new ArrayList<Integer>();
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Elegir el rango de números
		// TODO Poder poner tu nombre en las puntuaciones

		int intentosMaximos = pedirEntero("Dime el número de intentos máximo", MINIMO_INTENTOS_MAXIMO);
		
		do {
			partida(intentosMaximos);
		} while (pedirOtraPartida());

		cierre();
	}

	private static void partida(int intentosMaximos) {
		int pensado = new Random().nextInt(1, 10);
		int intentos = 0;
		
		int introducido;

		do {
			if(intentos >= intentosMaximos) {
				pl("Has perdido por sobrepasar el número de intentos máximo");
				return;
			}
			
			introducido = pedirEntero("Dime un número");

			intentos++;

			mostrarResultado(pensado, intentos, introducido);
		} while (pensado != introducido);

		puntuaciones.add(intentos);
	}

	private static void mostrarResultado(int pensado, int intentos, int introducido) {
		if (pensado > introducido) {
			pl("ES MAYOR");
		} else if (pensado < introducido) {
			pl("Es menor");
		} else {
			pl("HAS ACERTADO");
			pl("EFECTIVAMENTE EL NÚMERO ERA EL " + pensado);
			pl("Has necesitado " + intentos + " intentos");
		}
	}

	private static boolean pedirOtraPartida() {
		String otra = pedirTexto("¿Otra partida? (s/N)");

		return otra.equals("s");
	}

	private static void cierre() {
		sc.close();
		
		p("Puntuaciones: ");

		puntuaciones.sort((a, b) -> Integer.compare(a, b));

		pl(puntuaciones.toString());

		pl("Gracias por jugar");
	}
}
