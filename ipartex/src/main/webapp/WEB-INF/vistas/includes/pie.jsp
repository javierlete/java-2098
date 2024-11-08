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
<script src="js/bootstrap.bundle.min.js"></script>

<script src="js/jquery-3.7.1.js"></script>
<script src="js/dataTables.js"></script>
<script src="js/dataTables.bootstrap5.js"></script>
<script>
	new DataTable('table', {
		lengthMenu : [ [ 5, 10, 25, 50, -1 ], [ 5, 10, 25, 50, 'All' ] ],
		language : {
			url : 'json/dataTables_es-ES.json',
		},
	});
</script>
<script src="js/ipartex.js"></script>
</body>
</html>