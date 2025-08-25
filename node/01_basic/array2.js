fetch('http://192.168.0.83/HelloJSP/replyList.do?bno=145')
    .then((response) => response.json())
    .then((result) => 
    {
        result.filter((Ele) => 
        {
            if (Ele.replyer == 'user03')
                return 1;
        })
            .forEach(elem => 
            {
                console.log(elem.replyNo);
            });
    })
    .catch(console.error);
    
fetch('http://192.168.0.83/HelloJSP/replyList.do?bno=145')
    .then((response) => response.json())
    .then((result) => 
    {
        result.filter((Ele) => 
        {
            if (Ele.indexOf('연습'))
                return -1;
        })
            .forEach(elem => 
            {
                console.log(elem.replyNo);
            });
    })
    .catch(console.error);

//reply '연습' 포함된 댓글번호
// 글등록 연습.indexof('연습') => 01 반환(없음)