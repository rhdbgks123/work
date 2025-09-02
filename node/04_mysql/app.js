// app.js
const express = require("express");
const mysql = require("mysql2");
const parser = require("body-parser");
const sql = require("./sql");
const cors = require("cors");
const prodSql = require("./sql/sql");
const fs = require("fs");

// connect pool 생성.
const pool = mysql.createPool({
    host: "127.0.0.1",
    port: 3306,
    user: "dev01",
    password: "dev01",
    database: "dev",
    connectionLimit: 10,
});

const app = express();
app.use(parser.urlencoded()); // x-www-form-urlencoded
app.use(express.json({ limit: "10mb" }));
app.use(cors());
app.get("/", (req, resp) => {
    resp.send("/ 실행");
});
// console.log(prodSql['productList'].query);
// console.log(prodSql.productList.query);

app.post("/upload/:file_name", async (req, res) => {
    let file_name = req.params.file_name;
    let data = req.body.param;
    console.log(file_name);
    //console.log(data);
    console.log(req.body);
    fs.writeFile(__dirname + "/upload/" + file_name, data, "base64", (err) => {
        if (err) {
            res.send(err);
            return;
        }
        res.send("ok");
    });
});

//상품쿼리
app.post("/api/:alias", async (req, resp) => {
    //console.log(prodSql[req.params.alias].query)
    let search = prodSql[req.params.alias].query;
    let param = req.body.param;
    try {
        let result = await sql.excute(search, param);
        console.log(result);
        resp.json(result);
        // resp.send("조회성공");
    } catch (err) {
        resp.json({ retCode: "Error" });
        // resp.send("조회실패");
        console.log(err);
    }
});

app.get("/download/:product_id/:path", (req, res) => {
    let product_id = req.params.product_id;
    let path = req.params.path;
    res.header("Content-Type", `image/${path.substring(path.lastIndexOf(","))}`);
    const filepath = `${__dirname}/upload/${product_id}/${path}`;
    if (!fs.existsSync(filepath)) {
        res.send("NO IMAGE");
        return;
    }
    fs.createReadStream(filepath).pipe(res);
});

app.delete("/delapi/:alias", async (req, resp) => {
    //console.log(prodSql[req.params.alias].query)
    let search = prodSql[req.params.alias].query;
    let param = req.body.param;
    try {
        let result = await sql.excute(search, param);
        console.log(result);
        resp.json({ result });
        // resp.send("조회성공");
    } catch (err) {
        resp.json({ retCode: "Error" });
        // resp.send("조회실패");
        console.log(err);
    }
});

// 고객목록.
app.get("/customers", async (req, resp) => {
    try {
        let customerList = await sql.excute("select * from customers");
        console.log(customerList);
        resp.json({ customerList });
        // resp.send("조회성공");
    } catch {
        resp.json({ retCode: "Error" });
        // resp.send("조회실패");
        console.log(err);
    }
});

// 등록.
app.post("/customer", async (req, resp) => {
    console.log(req.body.param);
    try {
        let result = await sql.excute("insert into customers set ?", [req.body.param]);
        console.log(result);
        resp.json(result);
        // resp.send("조회성공");
    } catch (err) {
        console.error(err); // 에러 메시지를 찍어보기
        resp.json({ retCode: "Error" });
    }
});

// http://localhost:8080/boardList.do?page=3
// http://localhost:3000/customer/:id
app.delete("/customer/:id", async (req, resp) => {
    console.log(req.params.id);
    try {
        let result = await sql.excute("delete from customers where id = ?", [req.params.id]);
        console.log(result);
        resp.json(result);
        // resp.send("조회성공");
    } catch {
        resp.json({ retCode: "Error" });
        // resp.send("조회실패");
        console.log(err);
    }
});

app.put("/customer", async (req, resp) => {
    try {
        let result = await sql.excute("update customers set ? where id = ?", req.body.param);
        console.log(result);
        resp.json(result);
        // resp.send("조회성공");
    } catch (err) {
        resp.json({ retCode: "Error" });
        // resp.send("조회실패");
    }
});

app.listen(3000, () => {
    console.log("http://localhost:3000");
});
