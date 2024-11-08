async function megusta(id) {
	console.log('¡ME GUSTA! ' + id);

	const mensaje = document.querySelector('#m' + id);

	const a = mensaje.querySelector('a');
	const span = mensaje.querySelector('.numero-megusta');
	
	const numeroMegusta = +span.innerText;
	
	a.removeAttribute('href');

	const respuesta = await fetch('api/megusta?id=' + id);

	console.log('RESPUESTA RECIBIDA');

	if (respuesta.ok) {
		console.log('OK');

		console.log(mensaje);

		console.log(a);

		if (a.innerHTML.trim() === '<i class="bi bi-heart"></i>') {
			a.innerHTML = '<i class="bi bi-heart-fill text-danger"></i>';
			span.innerText = numeroMegusta + 1;
		} else {
			a.innerHTML = '<i class="bi bi-heart"></i>';
			span.innerText = numeroMegusta - 1;
		}
	} else {
		console.log('ERROR');
		const mensajeError = await respuesta.text();
		alert(mensajeError);
	}

	console.log('CANCELAR PROPAGACIÓN EVENTO');
	return false;
}