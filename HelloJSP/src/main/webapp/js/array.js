
let sum = 0;

var totalsum = (elem, idx, ary) =>
{
	sum += elem;
	if(idx == ary.length -1){
		console.log(`전체합계는 ${sum}`);
	}
}

var evensum = (elem, idx, ary) =>
{
	if(idx % 2 == 0)
	{
		sum += elem;
	}
	if(idx == ary.length -1){
		console.log(`짝수합계는 ${sum}`);
	}
}

var oddsum = (elem, idx, ary) =>
{
	if(idx % 2 == 1)
	{
		sum += elem;
	}
	if(idx == ary.length -1){
		console.log(`홀수합계는 ${sum}`);
	}
}

[12, 34, 83, 22, 59, 77].forEach(oddsum);