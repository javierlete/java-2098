package bases;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero2 {
	public static void main(String[] args) {
		// TODO Elegir el rango de números
		// TODO Número de intentos
		// TODO Número máximo de intentos
		// TODO Poder echar otra partida
		// TODO Ranking de puntuaciones
		// TODO Poder poner tu nombre en las puntuaciones
		
		Scanner sc = new Scanner(System.in);
		
		int pensado = new Random().nextInt(1, 100);

		int introducido;
		
		do {
			System.out.print("Dime un número: ");
			introducido = sc.nextInt();
			
			if(pensado > introducido) {
				System.out.println("ES MAYOR");
			} else if(pensado < introducido) {
				System.out.println("Es menor");
			} else {
				System.out.println("HAS ACERTADO. EFECTIVAMENTE EL NÚMERO ERA EL " + pensado);
			}
		} while(pensado != introducido);
		
		sc.close();
	}
}
