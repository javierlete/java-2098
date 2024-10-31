package ipartube.modelos;

public class Video {
	private Long id;
	private String nombre;
	private String descripcion;
	private String url;
	private Autor autor;

	private String errorNombre;
	private String errorDescripcion;
	private String errorUrl;
	private String errorAutor;

	public Video(Long id, String nombre, String descripcion, String url, Autor autor) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
		setUrl(url);
		setAutor(autor);
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
		if (nombre.isBlank()) {
			errorNombre = "El nombre no puede estar vacío";
		}

		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		if (descripcion.length() > 2000) {
			errorDescripcion = "La descripción no puede tener más de 2000 caracteres";
		}

		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		if (url.isBlank()) {
			errorUrl = "No se puede dejar la URL en blanco. ¿Qué video iba a mostrar?";
		}
		
		this.url = url;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		if (autor.getId() == 0) {
			errorAutor = "No se ha seleccionado ningún autor";
		}
		
		this.autor = autor;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public String getErrorDescripcion() {
		return errorDescripcion;
	}

	public String getErrorUrl() {
		return errorUrl;
	}

	public String getErrorAutor() {
		return errorAutor;
	}
	
	public boolean isCorrecto() {
		return errorNombre == null && errorDescripcion == null && errorUrl == null && errorAutor == null;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", url=" + url + ", autor="
				+ autor + ", errorNombre=" + errorNombre + ", errorDescripcion=" + errorDescripcion + ", errorUrl="
				+ errorUrl + ", errorAutor=" + errorAutor + "]";
	}

}
