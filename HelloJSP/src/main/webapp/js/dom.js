/*
<div id = 'show'>
	<ul id ="target">
		<li>apple</li>
		<li>banana</li>
	</ul>
</div> 
*/

let ul = document.createElement('ul'); // <ul> </ul> ul 태그생성
ul.setAttribute('id','target') // ul의 id값을 target으로 설정


let li = document.createElement('li'); // li 태그생성
let li2 = document.createElement('li'); // li 태그생성

li.innerText = 'apple'; // li에 apple 추가
li2.innerText = 'banana'; // li에 apple 추가

ul.appendChild(li); // ul에 자식요소 추가 (li)
ul.appendChild(li2); // ul에 자식요소 추가 (li)

console.log(ul);

// div#show 

document.querySelector('#show').appendChild(ul);
