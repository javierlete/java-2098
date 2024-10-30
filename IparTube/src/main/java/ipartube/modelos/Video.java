package ipartube.modelos;

public class Video {
	private Long id;
	private String nombre;
	private String descripcion;
	private String url;
	private Autor autor;

	public Video(Long id, String nombre, String descripcion, String url, Autor autor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.setUrl(url);
		this.autor = autor;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", url=" + url + ", autor="
				+ autor + "]";
	}

}
