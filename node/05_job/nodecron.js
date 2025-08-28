const cron = require('node-cron');

cron.schedule("5  *  *  *  *  *", () =>{
    let current = new Date();
    console.log(current.toISOString() + "실행됨");
})