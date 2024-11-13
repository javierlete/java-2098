package ipargram.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Entrada {
	private Long id;
	private String titulo;
	private LocalDateTime fechaHora;

	public Entrada(Long id, String titulo, LocalDateTime fechaHora) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fechaHora = fechaHora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public String getFechaHoraFormateada() {
		return fechaHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", titulo=" + titulo + ", fechaHora=" + fechaHora + "]";
	}

}
