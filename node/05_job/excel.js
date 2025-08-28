const xlsx = require("xlsx");
const sql = require("./sql");

async function  db_to_excel(){
    const workbook = xlsx.utils.book_new();
    let resultSet = await sql.excute("select * from customers");
    //console.log(resultSet);
    
    //workbook > sheet > cell
    // 시트 -> workbook -> customers.xlsx
    const firstSheet = xlsx.utils.json_to_sheet(resultSet, {header : ['id','name','email','phone','address']});
    
    xlsx.utils.book_append_sheet(workbook,firstSheet,"Customers");

    xlsx.writeFile(workbook, "./logs/customers2.xlsx");
    console.log('파일생성 완료');
    await sql.close();
}


async function excel_to_db()
{
    const workbook = xlsx.readFile("./logs/sample.xlsx");

    const firstSheetName = workbook.SheetNames[0];

    const firstSheet = workbook.Sheets[firstSheetName];

    let jsonSheet = xlsx.utils.sheet_to_json(firstSheet);

    jsonSheet.forEach(async (customer) => 
    {
        let result = await sql.excute("insert into customers set ?", customer);
        console.log(result);
    })

    console.log(jsonSheet);
    await sql.close();
    // xlsx.writeFile(workbook, "./logs/sample.xlsx");
}

module.exports = {
    db_to_excel
}