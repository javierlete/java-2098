package bases;

import java.util.Arrays;

public class ArraysEjemplo {
	public static void main(String[] args) {
		int[] puntuaciones = new int[10];
		
		puntuaciones[0] = 10;
		puntuaciones[4] = 40;
		
		System.out.println(puntuaciones[4]);
		System.out.println(puntuaciones[5]);
		
		System.out.println(puntuaciones.length);
		
		System.out.println(puntuaciones);
		
		for(int i = 0; i < puntuaciones.length; i++) {
			System.out.print(puntuaciones[i] + " ");
		}
		
		System.out.println();
		
		for(int dato: puntuaciones) {
			System.out.print(dato + " ");
		}
		
		System.out.println();
		
		System.out.println(Arrays.toString(puntuaciones));
	}
}
