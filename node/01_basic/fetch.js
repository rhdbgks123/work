async function getPost()
{
    let response = await fetch('http://localhost:3000/posts');
    let data = await response.json();
    data.forEach(post =>
    {
        getComments(post.id);
    });
    
}

async function getComments(postId)
{
    let response = await fetch('http://localhost:3000/comments');
    let data = await response.json();
    console.log('글' + postId + '번에 대한 comments list');
    data.forEach(comment =>
    {
        if(comment.postId == postId)
            console.log('    내용 : '+ comment.body);
    })
}

getPost();

// fetch("http://localhost:3000/posts")
// .then(response => response.json())
// .then(data => 
// {
//     console.log(data);
//     // post에 대한 comments 조회
//     data.forEach(post =>
//     {
//         fetch('http://localhost:3000/comments')
//         .then(response => response.json())
//         .then(data =>
//         {
//             console.log('글' + post.id+'번에 대한 comments list');
//             data.forEach(comment =>
//             {
//                 if(comment.postId == post.id)
//                 {
//                     console.log('    내용 : '+ comment.body)
//                 }
//             })
//         })
//         .catch(console.error);
//     })

// })
// .catch(console.error);

// fetch("http://localhost:3000/comments", 
// {
//     method : "post",
//     body: JSON.stringify({ id:3, body : 'comments tesT3', postId:2}),
//     headers : {'Content-Type':'application/json;charset=utf-8'},
// })
// .then(response => response.json())
// .then(data => 
// {
//     console.log(data);
// })
// .catch(console.error);