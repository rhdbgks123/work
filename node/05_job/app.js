const express = require("express");
const nodemail = require("./nodemail");
// const excel = require("./excel");
const xlsx = require("xlsx");
const sql = require("./sql");
const query = require("./sql/sql")

require("dotenv").config({
    path:"./.env"
});
const app = express();
const process = require("process");

// console.log(process.env);

app.use(express.urlencoded());

// 라우팅정보
app.get("/", (req, res) => {
    res.send("/");
})

app.get("/mail", (req,res) => {
    res.send
    (`    
        <form action = "mail" method="post">
            <table>
                <tr>
                    <th>보내는이 :</th>
                    <td><input type ="email" name = "sender" value = "rhdbgks456@daum.net"/></td>
                </tr>
                <tr>
                    <th>받는이 :</th>
                    <td><input type ="email" name = "receiver"/></td>
                </tr>
                <tr>
                    <th>제목 :</th>
                    <td><input type ="text" name = "subject"/></td>
                </tr>
                <tr>
                    <th>내용 :</th>
                    <td><textarea name = "content"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value = "Post요청"/>
                    </td>
                </tr>
            </table>
        </form>
    `);
})

app.post("/mail", (req,res) =>{
    console.log(req.body);
    let data = 
    { 
        from : req.body.sender,
        to : req.body.receiver,
        subject : req.body.subject,
        text : req.body.content
    }
    console.log(data);
     nodemail.mailSend(data);
     res.send("done");
})

// "/excel_down" => customers 테이블의 데이터를 logs/customer2.xlsx로 저장
app.get("/excel_down", async (req, res) => {
    // excel.db_to_excel();
    const workbook = xlsx.utils.book_new();

    let rs = await sql.excute("select * from customers");
    const firstSheet = xlsx.utils.json_to_sheet(rs, {header : ['id','name','email','phone','address']});
    xlsx.utils.book_append_sheet(workbook, firstSheet);

    xlsx.writeFile(workbook, "./logs/customer3.xlsx");

    res.send("done");
})

app.listen(3000, () =>{
    console.log("http://localhost:3000");
})