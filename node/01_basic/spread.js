// ... args 펼침연산자

let ar1 = [1,2,3];
let ar2 = [4,5,6];

let result = [ar1,ar2];
console.log(result);

let str = "abcde";

console.log(...str);

let obj = {firstName:'kildong', lastName:'Hong', age:20};

let fn = obj.firstName;
let ln = obj.lastName;
let ag = obj.age;

let {firstName, lastName, age} =  obj;

console.log(firstName, lastName, age);