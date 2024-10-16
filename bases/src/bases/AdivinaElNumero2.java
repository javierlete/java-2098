package bases;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero2 {
	public static void main(String[] args) {
		// TODO Elegir el rango de números
		// TODO Número máximo de intentos
		// TODO Ranking de puntuaciones
		// TODO Poder poner tu nombre en las puntuaciones
		
		Scanner sc = new Scanner(System.in);
		
		boolean otraPartida;
		
		do {
			int pensado = new Random().nextInt(1, 10);
			int intentos = 0;
			int introducido;
			
			do {
				System.out.print("Dime un número: ");
				introducido = sc.nextInt();
				sc.nextLine();
				
				intentos++;

				if (pensado > introducido) {
					System.out.println("ES MAYOR");
				} else if (pensado < introducido) {
					System.out.println("Es menor");
				} else {
					System.out.println("HAS ACERTADO");
					System.out.println("EFECTIVAMENTE EL NÚMERO ERA EL " + pensado);
					System.out.println("Has necesitado " + intentos + " intentos");
				}
			} while (pensado != introducido);
			
			System.out.print("¿Otra partida? (s/N): ");
			String otra = sc.nextLine();
			otraPartida = otra.equals("s");
		} while (otraPartida);
		
		System.out.println("Gracias por jugar");
		
		sc.close();
	}
}
