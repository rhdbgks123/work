// console에 hello,world 구문

// export{myFunc, defaultNum, sum, minus};

const defaultNum =12;

const sum = (num1 = 0, num2 = 0) =>
{
    return num1 + num2;
} 

function myFunc ()
{
    console.log("hello, world");
}
function minus(num1 = 0, num2 =0)
{
    return num1 - num2;
}

module.exports = 
{
    myFunc, defaultNum, sum, minus
}
