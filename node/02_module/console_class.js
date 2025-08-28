const{Console, log} = require('console');
const fs = require("fs");
const {defaultNum} = require("./helloworld");
const now = new Date();

const output = fs.createWriteStream('./stdout.log', { flags: 'a' });

const errput = fs.createWriteStream('./stderr.log', { flags: 'a' });

const logger = new Console({stdout:output, stderr:errput});

logger.log('디폴트값 : %d',defaultNum);

logger.error(`[${now}]에러발생`);

for(let i = 0 ; i < 10 ; i ++)
{
    console.log(`i의 값은 ${i}`);
}