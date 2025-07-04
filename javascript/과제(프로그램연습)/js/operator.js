let num1 = document.querySelector("#num1");
let num2 = document.querySelector("#num2");
let result = document.querySelector("#result");

let addBtn = document.querySelector("#add");
let subBtn = document.querySelector("#sub");
let multyBtn = document.querySelector("#multy");
let dividBtn = document.querySelector("#divid");

addBtn.onclick = addCal;
subBtn.onclick = subCal;
multyBtn.onclick = multyCal;
dividBtn.onclick = dividCal;

function addCal()
{
    result.value = parseInt(num1.value) + parseInt(num2.value);
}
function subCal()
{
    result.value = parseInt(num1.value) - parseInt(num2.value);
}
function multyCal()
{
    result.value = parseInt(num1.value) * parseInt(num2.value);
}
function dividCal()
{
    result.value = parseInt(num1.value) / parseInt(num2.value);
}

