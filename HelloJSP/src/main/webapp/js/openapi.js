document.addEventListener('DOMContentLoaded', () => {
	document.querySelector("#search").addEventListener('change', e => drawRow(e.target.value));
	insert();
});
allData = [];

async function insert() {
	let result = await getCORONA();
	allData = result.data;
	let allsido = allData.reduce((acc, elem) => {
		if (acc.indexOf(elem.sido) == -1)
			acc.push(elem.sido);
		return acc;
	}, []);

	allsido.forEach(elem => {
		let option = document.createElement('option');
		option.setAttribute("value", elem);
		option.innerText = elem;
		document.querySelector("#search").appendChild(option);
	});
	drawRow('전체');
}

async function getCORONA() {

	let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=vX9WzIkueezdeHXfo6W9R5sRy9whgunBTX3sZNpV9KY77wpnu2zVQ3opdYtVbuX7sBeunH%2FgTgp0F7GpP0oDHw%3D%3D`;
	let resolve = await fetch(url);
	let result = await resolve.json();
	return result;
}

function drawRow(value) {
	document.querySelector('#list').innerHTML = "";
	allData.forEach(elem => {
		if (value == '전체' || elem.sido == value) {
			let tr = document.createElement('tr');
			tr.addEventListener('click',function(e){window.open('daumapi.jsp?lat='+elem.lat+'&lng='+elem.lng+'&centerName='+elem.centerName)});
			['id', 'centerName', 'phoneNumber'].forEach(prop => {
				let td = document.createElement('td');
				td.innerText = elem[prop]
				tr.appendChild(td);
			})
			document.querySelector('#list').appendChild(tr);
		}

	});
}