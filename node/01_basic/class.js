let std1 = 
{
    stdNo : 1234,
    stdName : '홍길동',
    height : 170,
    weight : 68,
    eat : function(food){ console.log(food + " 먹기"); },
    sleep(hours){ console.log(hours + " 동안 자기"); }
};

class Student
{
    constructor(stdNo, stdName, height, weight)
    {
        this.stdNo = stdNo;
        this.stdName = stdName;
        this.height = height;
        this.weight = weight;
    };
    
    eat(food)
    { 
        console.log(food + " 먹기"); 
    }

    sleep(hours)
    {
        console.log(hours + " 동안 자기"); 
    }
}

let std2 = new Student(5678, '김민수',180,75);

console.log(std2.stdNo, std2.stdName);