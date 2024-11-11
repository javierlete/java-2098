package ipartex.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Mensaje {
	private static final String FORMATO_FECHA = "yyyy-MM-dd HH:mm:ss";
	public static final DateTimeFormatter FORMATEADOR_FECHA = DateTimeFormatter.ofPattern(FORMATO_FECHA);
	
	private Long id;
	private Usuario usuario;
	private LocalDateTime fecha;
	private String texto;
	private Long numeroLesGusta;
	
	private ArrayList<Usuario> usuariosLesGusta = new ArrayList<Usuario>();

	public Mensaje(Long id, Usuario usuario, LocalDateTime fecha, String texto, Long numeroLesGusta) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.texto = texto;
		this.numeroLesGusta = numeroLesGusta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public ArrayList<Usuario> getUsuariosLesGusta() {
		return usuariosLesGusta;
	}
	
	public Long getNumeroLesGusta() {
		return numeroLesGusta;
	}
	
	public String getFechaFormateada() {
		return fecha.format(FORMATEADOR_FECHA);
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", usuario=" + usuario + ", fecha=" + fecha + ", texto=" + texto + "]";
	}
	
	
}
