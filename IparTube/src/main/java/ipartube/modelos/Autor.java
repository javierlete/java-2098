package ipartube.modelos;

import java.util.ArrayList;

public class Autor {
	private Long id;
	private String email;
	private String password;
	private String nombre;
	private String descripcion;

	private ArrayList<Video> videos = new ArrayList<>();

	public Autor(Long id, String email, String password, String nombre, String descripcion) {
		setId(id);
		setEmail(email);
		setPassword(password);
		setNombre(nombre);
		setDescripcion(descripcion);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
