<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%="</main>"%>

<footer
	class="text-bg-dark p-2 fixed-bottom d-flex justify-content-between">
	<p>&copy;2024 Javier Lete</p>
	<ul class="nav">
		<li class="nav-item"><a class="p-1" href="#"><i
				class="text-light bi bi-facebook"></i></a>
		<li class="nav-item"><a class="p-1" href="#"><i
				class="text-light bi bi-instagram"></i></a>
		<li class="nav-item"><a class="p-1" href="#"><i
				class="text-light bi bi-youtube"></i></a>
		<li class="nav-item"><a class="p-1" href="#"><i
				class="text-light bi bi-tiktok"></i></a>
	</ul>
</footer>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>
<script
	src="https://cdn.datatables.net/2.1.8/js/dataTables.bootstrap5.js"></script>
<script>
	new DataTable('table', {
		lengthMenu: [
	        [5, 10, 25, 50, -1],
	        [5, 10, 25, 50, 'All']
	    ],
	    language: {
	        url: '//cdn.datatables.net/plug-ins/2.1.8/i18n/es-ES.json',
	    },
	});
</script>
</body>
</html>