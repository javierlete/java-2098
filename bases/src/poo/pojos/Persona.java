package poo.pojos;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	// CONSTANTES (VARIABLES ESTÁTICAS -> "VARIABLES DE CLASE")
	public static final int MAYORIA_DE_EDAD = 18;
	public static final LocalDate FECHA_POR_DEFECTO = null;
	
	// VARIABLES DE INSTANCIA
	private String nombre = "ANONIMO";
	private LocalDate fechaNacimiento;

	// CONSTRUCTORES
	public Persona(String nombre, LocalDate fechaNacimiento) {
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public Persona(String nombre) {
		this(nombre, FECHA_POR_DEFECTO);
	}

	public Persona() {
		this("ANONIMO", FECHA_POR_DEFECTO);
	}

	// Constructor de copia
	public Persona(Persona persona) {
		this(persona.getNombre(), persona.getFechaNacimiento());
	}
	
	// MÉTODOS DE ACCESO (GETTERS Y SETTERS)
	public void setNombre(String nombre) {
		
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("Necesito un nombre para funcionar");
		}
		
		nombre = nombre.trim();

		if(nombre.length() < 3) {
			throw new IllegalArgumentException("No se admiten nombres con menos de tres letras");
		}

		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento != null && getEdadLegal(fechaNacimiento) < MAYORIA_DE_EDAD) {
			throw new IllegalArgumentException("Debe ser mayor de edad");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}
	
	// OTROS MÉTODOS
	public int getEdadLegal() {
		if(fechaNacimiento == null) {
			throw new IllegalStateException("No tenemos fecha de nacimiento");
		}
		
		return getEdadLegal(fechaNacimiento);
	}

	public int getEdad() {
		if(fechaNacimiento == null) {
			throw new IllegalStateException("No tenemos fecha de nacimiento");
		}
		
		return getEdad(fechaNacimiento);
	}
	
	public static int getEdad(LocalDate fechaNacimiento) {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}

	public static int getEdadLegal(LocalDate fechaNacimiento) {
		return Period.between(fechaNacimiento.plusDays(1), LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}
