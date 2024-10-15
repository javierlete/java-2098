package bases;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// El ordenador piensa un número
		
		// int objetivo = (int)(Math.random() * 100) + 1;
		Random generador = new Random();
		int pensado = generador.nextInt(1, 100);
		
		do {
			// "Dime un número"
			System.out.print("Dime un número: ");
			// Pedir el número
			int introducido = sc.nextInt();
			// ¿Número pensado > número introducido?
			if (pensado > introducido) {
				// "ES MAYOR"
				System.out.println("ES MAYOR");
			} else {
				// ¿Número pensado = número introducido?
				if (pensado == introducido) {
					// "HAS ACERTADO"
					System.out.println("HAS ACERTADO");
					// Fin
					// System.exit(0);
					break;
				} else {
					// "ES MENOR"
					System.out.println("Es menor");
				}
			} 
		} while (true);
		
		sc.close();
	}
}
