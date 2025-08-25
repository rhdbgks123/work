//[].sort;

let fruits = ['apple', 'cherry', 'banana'];

fruits.sort();fruits.forEach(fruits => 
{
    console.log(fruits);
});

let numbers = [1, 10, 100, 2, 12, 44];

numbers.sort(function (a, b) 
{
    if (a > b)     
    {
        return 1; // 위치변경 : 양수
    }
    else     
    {
        return -1; // 위치유지 : 음수
    }
});numbers.forEach((number) => 
{
    console.log(number);
});
