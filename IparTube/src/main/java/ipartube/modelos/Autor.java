package ipartube.modelos;

import java.util.ArrayList;

public class Autor {
	private Long id;
	private String nombre;
	private String descripcion;

	private ArrayList<Video> videos = new ArrayList<>();

	public Autor(Long id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Video> getVideos() {
		return videos;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
