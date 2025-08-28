
const { rejects } = require("assert");
const mysql = require("mysql2");
const { resolve } = require("path");
// connect pool 생성.
const pool = mysql.createPool({
  host: "127.0.0.1",
  port: 3306,
  user: "dev01",
  password: "dev01",
  database: "dev",
  connectionLimit: 10,
});

function excute(sql = "select * from customers", param = []) {
    return new Promise((resolve, reject) => {
        pool.getConnection((err, connection) => {
            // getConnection => connection 객체 획득.
            if (err) {
                return reject(err);
            }
            connection.query(sql, param, (qErr, results) => {
                connection.release(); // connection => pool 환원.
                if (qErr) {
                    return reject(qErr);
            }
            resolve(results)
            }); // end of query().
        }); // end of getConnection().
    });
 
}
function close() {
    return new Promise((resolve, reject) => {
        pool.end(err => {
            if (err) return reject(err);
            resolve();
        });
    });
}

module.exports =
{
    excute,
    close
}