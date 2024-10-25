package controladores;

import java.io.IOException;
import java.math.BigDecimal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import poo.pojos.Producto;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		Producto producto = null;

		if (sId != null) {
			Long id = Long.parseLong(sId);
			producto = globales.Global.almacen.getProductoPorId(id);

			request.setAttribute("producto", producto);
		}

		request.getRequestDispatcher("form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir datos de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");

		// 2. Convertir los datos
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		BigDecimal precio = sPrecio.isBlank() ? null : new BigDecimal(sPrecio);

		if(nombre.isBlank()) {
			request.setAttribute("errores", "El nombre debe ser rellenado");
			request.getRequestDispatcher("form.jsp").forward(request, response);
			return;
		}
		
		// 3. Empaquetar en modelo
		Producto producto = new Producto(id, nombre, precio);

		// 4. Lógica de negocio
		if (id == null) {
			globales.Global.almacen.meterProducto(producto);
		} else {
			globales.Global.almacen.modificarProducto(producto);
		}

		// 5. Preparar la información para la vista
		// NO HAY

		// 6. Ir a la vista/controlador
		response.sendRedirect("admin");
	}
}
