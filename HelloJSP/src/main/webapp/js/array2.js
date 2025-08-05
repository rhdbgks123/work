/*
 filter 배열 메소드.
 
 요소의 값 -> true일 때 그 요소를 새로운 배열에 생성.
 */



function makeRow(member)
{
	//console.log(`${id}, ${first_name}, ${last_name}, ${email}`);
		let tr = document.createElement('tr');
		for (let prop in member) 
		{
			let td = document.createElement('td');
			td.innerText=member[prop]; // <td>Messi</td>
			tr.appendChild(td);
				
			//console.log(`속성 : ${prop}, 값 ${member[prop]}`);
		}
		
		let button = document.createElement('button')
		button.setAttribute('input', 'button');
		button.setAttribute('id','del');
		button.setAttribute('name','del')
		button.innerText = "삭제";
		
		// button 이벤트, 이벤트 핸들러 추가
		// eventhanddler의 변수는 e로 규칙
		button.addEventListener('click',(e) => {
			
			//console.log(e.target);
			let parent = e.target.parentElement.parentElement;
			let fn = parent.children[1].innerText;
			let ln = parent.children[2].innerText;
			if(confirm(`${fn} ${ln}을 삭제하시겠습니까?`))
			{
				e.target.parentElement.parentElement.remove();
			}
			//e.target.parentElement.parentElement.remove();
		}); 
		
		let td2 = document.createElement('td');
		td2.appendChild(button)
		tr.appendChild(td2);
		return tr;
};

// 급여가 7000 이상인 사람들을 목록에 표시

members.filter(elem => elem.salary >= 7000).filter(elem => elem.gender =='Female').map(elem =>
	{
		let {id, first_name, last_name, salary} = elem;
		let obj = {id, first_name, last_name, salary};
		return obj;
	}
	
).forEach(elem =>	document.querySelector('#show tbody').appendChild(makeRow(elem)));


 let result = [10, 20, 30, 40, 50].filter((elem, idx, ary) => 
	{
		if(elem >= 30)
		{
			return true;
		}
	}
);