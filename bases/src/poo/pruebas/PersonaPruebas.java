package poo.pruebas;

import java.time.LocalDate;

import poo.pojos.Persona;

public class PersonaPruebas {
	public static void main(String[] args) {
		Persona p = null;
		
		System.out.println(p);
		
		p = new Persona();
		
		mostrar(p);
		
		p.setNombre("    sdfgsdf  ");
		p.setFechaNacimiento(null); // LocalDate.now()); // .minusYears(18));
		
		mostrar(p);
		
		Persona p2 = new Persona();
		
		p2.setNombre("Juan");
		p2.setFechaNacimiento(LocalDate.now().minusYears(18).minusDays(1));

		mostrar(p2);
		
		Persona p3 = new Persona("Javier", LocalDate.now().minusYears(30));
		
		mostrar(p3);
		
		Persona p4 = new Persona("  asdfasd  ");
		
		mostrar(p4);
		
		Persona p5 = new Persona("Con edad", LocalDate.of(2000, 10, 18));
		
		System.out.println(p5.getEdad());
		System.out.println(p5.getEdadLegal());
		
		System.out.println(p5);
		
		Persona p6 = new Persona(p5); // hace copia, a diferencia de Persona p6 = p5;
		
		p6.setNombre("Cambiado");
		
		System.out.println("p5 = " + p5);
		System.out.println("p6 = " + p6);
		
		System.out.println(Persona.getEdad(LocalDate.now().minusYears(18)));
		System.out.println(Persona.getEdadLegal(LocalDate.now().minusYears(18)));
		
		System.out.println(Persona.isMayorDeEdad(LocalDate.now().minusYears(18)));
		System.out.println(Persona.isMayorDeEdad(LocalDate.now().minusYears(18).minusDays(1)));
	}

	private static void mostrar(Persona persona) {
		System.out.println(persona.getNombre());
		System.out.println(persona.getFechaNacimiento());
	}
}
