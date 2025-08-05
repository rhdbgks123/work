/*
	object.js
*/

//console.log(members);

//console.log(members[0]);

//let fisrt_name = member.first_name;
/*
for(let member of members)
{
	//let member = members[0];
	let{id, first_name, last_name, email} = member;
	
	//console.log(`${id}, ${first_name}, ${last_name}, ${email}`);
	
	for (let prop in member) 
	{
		//console.log(`속성 : ${prop}, 값 ${member[prop]}`);
	}
}
*/

for(let member of members)
{
	//let member = members[0];
	let{id, first_name, last_name, email, gender, salary} = member;
	
	//console.log(`${id}, ${first_name}, ${last_name}, ${email}`);
	let tr = document.createElement('tr');
	for (let prop in member) 
	{
		console.log(prop);
		if(prop == 'gender')
		{
			if(member[prop] == 'Female')
			{
				tr.style.backgroundColor = 'pink';	
			}	
			else if (member[prop] = 'Male')
			{
				tr.style.backgroundColor = 'yellow'	;
			}
		}
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
		console.log(parent.children);
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
	document.querySelector('#show tbody').appendChild(tr);
	
}

let sum = 0;
// 아래 두개 동일
document.querySelectorAll('#show tbody tr td:nth-of-type(6)').forEach(elem=> sum+= parseInt(elem.innerText));
console.log(sum);

document.querySelectorAll('#show tbod tr').forEach(elem => sum+= parseInt(elem.children[5].innerText));
console.log(sum);