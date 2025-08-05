/**
 * ajax.js
 * 
 */

// 동기방식 vs 비동기방식

//비동기방식
setTimeout(function() {	
	console.log('1');
}, 1000);
setTimeout(function() {	
	console.log('2');
}, 2000);
setTimeout(function() {	
	console.log('3');
}, 500);

//동기방식

setTimeout(function() {
	console.log('1');
	setTimeout(function() {
		console.log('2');
		setTimeout(function() {
			console.log('3');
		}, 500);
	}, 2000);
}, 1000);

// 대표적인 비동기방식 객체 예전에 사용
const xhtp = new XMLHttpRequest();

