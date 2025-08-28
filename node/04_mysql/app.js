// app.js
const express = require("express");
const mysql = require("mysql2");
const parser = require("body-parser");
const sql = require("./sql");
const prodSql = require("./sql/sql");

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
app.use(parser.json());

app.get("/", (req, resp) => {
  resp.send("/ 실행");
});
// console.log(prodSql['productList'].query);
// console.log(prodSql.productList.query);
//상품쿼리
app.post("/api/:alias", async (req, resp) =>  {
    //console.log(prodSql[req.params.alias].query)
    let search = prodSql[req.params.alias].query;
    let param = req.body.param;
    try
    {
        let result = await sql.excute(search, param);
        console.log(result);
        resp.json({retCode : "OK", result});
        // resp.send("조회성공");
    }
    catch(err){
        resp.json({retCode:"Error"});
        // resp.send("조회실패");
        console.log(err);
    }
});

app.delete("/delapi/:alias", async (req, resp) =>  {
    //console.log(prodSql[req.params.alias].query)
    let search = prodSql[req.params.alias].query;
    let param = req.body.param;
    try
    {
        let result = await sql.excute(search, param);
        console.log(result);
        resp.json({retCode : "OK", result});
        // resp.send("조회성공");
    }
    catch(err){
        resp.json({retCode:"Error"});
        // resp.send("조회실패");
        console.log(err);
    }
});

// 고객목록.
app.get("/customers", async (req, resp) =>  {
    try
    {
        let customerList = await sql.excute("select * from customers");
        console.log(customerList);
        resp.json({retCode : "OK", customerList});
        // resp.send("조회성공");
    }
    catch{
        resp.json({retCode:"Error"});
        // resp.send("조회실패");
        console.log(err);
    }
});

// 등록.
app.post("/customer", async (req, resp) => {
  console.log(req.body.param);
    try
    {
        let result = await sql.excute("insert into customers set ?", [req.body.param]);
        console.log(result);
        resp.json(result);
        // resp.send("조회성공");
    }
    catch (err) {
        console.error(err);   // 에러 메시지를 찍어보기
        resp.json({ retCode: "Error" });
    }
});

// http://localhost:8080/boardList.do?page=3
// http://localhost:3000/customer/:id
app.delete("/customer/:id", async (req, resp) => {
    console.log(req.params.id)
    try
    {
        let result = await sql.excute("delete from customers where id = ?", [req.params.id]);
        console.log(result);
        resp.json(result);
        // resp.send("조회성공");
    }
    catch{
        resp.json({retCode:"Error"});
        // resp.send("조회실패");
        console.log(err);
    }
});

app.put("/customer", async (req, resp) => {
    try
    {
        let result = await sql.excute("update customers set ? where id = ?", req.body.param);
        console.log(result);
        resp.json(result);
        // resp.send("조회성공");
    }
    catch (err){
        resp.json({retCode:"Error"});
        // resp.send("조회실패");
    }
});

app.listen(3000, () => {
  console.log("http://localhost:3000");
});