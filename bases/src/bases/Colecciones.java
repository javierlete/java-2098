package bases;

import java.util.ArrayList;

public class Colecciones {
	public static void main(String[] args) {
		var puntuaciones = new ArrayList<Integer>();
		
		System.out.println(puntuaciones);
		System.out.println(puntuaciones.size());
		
		puntuaciones.add(5);
		puntuaciones.add(3);
		puntuaciones.add(7);
		puntuaciones.add(1);
		
		System.out.println(puntuaciones);
		System.out.println(puntuaciones.size());

		puntuaciones.remove(2);
		System.out.println(puntuaciones);
		System.out.println(puntuaciones.size());

		puntuaciones.add(0, 2);
		System.out.println(puntuaciones);
		System.out.println(puntuaciones.size());
		
		puntuaciones.set(3, 10);
		System.out.println(puntuaciones);
		System.out.println(puntuaciones.size());
		
		for(int i = 0; i < puntuaciones.size(); i++) {
			System.out.println(puntuaciones.get(i));
		}
		
		for(int dato: puntuaciones) {
			System.out.println(dato);
		}
		
		// Buscar un dato
		for(int dato: puntuaciones) {
			if(dato == 5) {
				System.out.println("Encontrado");
				break;
			}
		}
		
		boolean encontrado = false;
		
		for(int i = 0; i < puntuaciones.size() && !encontrado; i++) {
			if(puntuaciones.get(i) == 5) {
				System.out.println("Encontrado");
				encontrado = true;
			}
		}
	}
}
