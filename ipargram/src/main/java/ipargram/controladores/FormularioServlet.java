package ipargram.controladores;

import java.io.IOException;
import java.time.LocalDateTime;

import ipargram.accesodatos.EntradaAccesoDatos;
import ipargram.modelos.Entrada;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/formulario")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recoger información de la petición
		String rutaImagenes = request.getServletContext().getRealPath("/imgs/");
		
		String titulo = request.getParameter("titulo");
		String sFechaHora = request.getParameter("fecha-hora");
		Part partImagen = request.getPart("imagen");
		
		
//		Convertir la información al tipo adecuado
		LocalDateTime fechaHora = LocalDateTime.parse(sFechaHora);
		
//		Crear objetos de modelo de los datos
		var entrada = new Entrada(null, titulo, fechaHora);
		
//		Realizar la operación de negocio
		var entradaConId = EntradaAccesoDatos.insertar(entrada);
		
		if(!partImagen.getSubmittedFileName().isBlank()) {
			partImagen.write(rutaImagenes + entradaConId.getId() + ".jpg");
		}
		
//		Empaquetar la información para la siguiente pantalla
		request.setAttribute("entrada", entrada);
		
//		Saltar a la siguiente pantalla
		request.getRequestDispatcher("/WEB-INF/vistas/entrada.jsp").forward(request, response);

	}
}
