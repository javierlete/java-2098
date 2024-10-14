package bases;

import java.util.Scanner;

public class LeerConsola {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String nombre;
		
		do {
			System.out.print("Dime tu nombre: ");
			nombre = sc.nextLine();
			
			if (nombre.isBlank()) {
				System.out.println("Introduce un nombre, no me lo dejes en blanco.");
			} else {
				System.out.println("Hola " + nombre.trim());
			} 
		} while (nombre.isBlank());
		
		System.out.print("Dime un número: ");

		int a = sc.nextInt();

		System.out.print("Dime un número: ");

		int b = sc.nextInt();

		int suma = a + b;

		System.out.println("El resultado de " + a + " + " + b + " = " + suma);

		System.out.printf("El resultado de %s + %s = %s\n", a, b, suma);

		sc.close();
	}
}
