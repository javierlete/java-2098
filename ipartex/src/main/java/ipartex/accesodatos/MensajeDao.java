package ipartex.accesodatos;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ipartex.modelos.Mensaje;
import ipartex.modelos.Usuario;

public class MensajeDao {
	public static ArrayList<Mensaje> getMensajes() {
		var mensajes = new ArrayList<Mensaje>();
		
		Usuario javier = new Usuario(1L, "Javier Lete", "javier@email.net", null);
		Usuario pepe = new Usuario(2L, "Pepe Pérez", "pepe@email.net", null);
		
		Mensaje mensaje1 = new Mensaje(1L, javier, LocalDateTime.now(), "En una clase de informática de cuyo nombre no me da la gana de acordarme");
		Mensaje mensaje3 = new Mensaje(3L, pepe, LocalDateTime.now(), "Pepe dice que esto es lo mejor del mundo mundial");
		
		mensaje1.getUsuariosLesGusta().add(pepe);
		mensaje1.getUsuariosLesGusta().add(javier);
		
		mensaje3.getUsuariosLesGusta().add(pepe);
		
		mensajes.add(mensaje1);
		mensajes.add(new Mensaje(2L, pepe, LocalDateTime.now(), "me da la gana de acordarme"));
		mensajes.add(mensaje3);
		mensajes.add(new Mensaje(4L, javier, LocalDateTime.now(), "nombre no me da la gana de acordarme"));
		
		return mensajes;
	}
}
