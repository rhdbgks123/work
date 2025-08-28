// import { myFunc, defaultNum, sum, minus } from "./helloworld.js";

const {myFunc, defaultNum, sum, minus} = require("./helloworld.js");

myFunc();

console.log(sum(defaultNum, 50));
console.log(minus(defaultNum, 50));
