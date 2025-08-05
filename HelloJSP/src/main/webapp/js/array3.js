/*
array3.js 
reduce
 */

let students = [{ name: "홍길동", score: 80 }, { name: "김민규", score: 85 }, { name: "박흥부", score: 87 }, { name: "김길동", score: 76 }];

let newAry = students.reduce((acc, elem, idx) =>
	{
		
		if (elem.score >= 80)
			acc.push(elem)
		return acc;
	}, []
)
	console.log(newAry);
	
let res = students.reduce((acc, elem, idx) =>
		{
			let tr = document.createElement('tr');
			for(let prop in elem)
				{
					let td = document.createElement('td');
					td.innerText = elem[prop];
					tr.appendChild(td);
				}
			acc.appendChild(tr);
			return acc;
		}, document.querySelector('#item tbody')
	);

 let numAry2 = [10, 20, 30, 40, 50];
 let result2 = numAry2.reduce((acc, elem, idx, ary) => 
	{
		return acc + elem;		
	}, 0
);

console.log(result2);

 let numAry = [10, 20, 30, 40, 50];
 let result = numAry.reduce((acc, elem, idx, ary) => 
	{
		// acc의 초기값은 빈 배열 []
		if(elem % 2 == 0)
		{
			acc.push(elem);	
		}
		return acc; // 짝수의 경우 acc return = 두번째 체크 때 acc 값에 짝수만 들어있는 배열 호출 가능		
	}, []
);
