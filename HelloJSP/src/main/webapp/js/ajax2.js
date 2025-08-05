
//Promise 객체
//정상일경우 then 아닐경우 catch
/*
fetch('js/dataset.xml') // xml형식은 이제 안씀
.then(function(result)
	{
		console.log(result)
		return result.text(); // Promise객체타입 반환
	}
)
.then(function(result)
	{
		console.log(result)	
	}
)
.catch(function(err)
	{
		console.log(err)
	}
)
*/

fetch('js/MOCK_DATA.json')
.then(result => result.json())
.then(function(result)
	{
		console.log(result);	
		result.forEach(elem => 
		{
			let tr = document.createElement('tr');
			['id','first_name','last_name','salary'].forEach(field => {
				let td = document.createElement('td');
				td.innerText = elem[field]; // 값
				tr.appendChild(td);
			})	
			
			let td=document.createElement('td');
			let btn = document.createElement('btn');
			btn.innerText = '삭제';
			td.appendChild(btn);
			tr.appendChild(td);
			
			document.querySelector('#show tbody').appendChild(tr);
		})
	}
)
.catch(function(err)
	{
		console.log(err)
	}
)

