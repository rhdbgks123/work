fetch('http://192.168.0.83/HelloJSP/mock.json')
.then((response) => response.json())
.then((data) => 
{
    console.log(data);
    data.map(elem =>     
    {
        const newElem = 
            {
                id : elem.id, name : elem.first_name + '/' + elem.last_name,
                email : elem.email,
                salary : elem.salary
            };

        return newElem;
    })
    .forEach(element => 
    {
        console.log(element.id + ':' + element.name);   
    });
})

.catch(console.error);