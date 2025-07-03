//input 상자 접근
let uId = document.querySelector('#user-id');
let uPw1 = document.querySelector('#user-pw1');
let uPw2 = document.querySelector('#user-pw2');

//입력상자에 값이 바뀌는 이벤트 발생하면 이벤트 핸들러 연결
uId.onchange = idCheck;
uPw1.onchange = pwCheck;
uPw2.onchange = pwCheck2;


// id 길이 체크
function idCheck()
{
    let idLen = uId.value.length;
    if(idLen < 3 || idLen > 10)
    {
        alert("ID 길이를 다시 확인해 주세요. 3~10글자만 가능합니다.");
        uId.select();
    }
}


//비밀번호 길이 체크
function pwCheck()
{
    let pwLen = uPw1.value.length;
    if(pwLen < 4)
    {
        alert("PW 길이를 다시 확인해 주세요. 4글자 이상만 가능합니다. ");
        uPw1.value = "";
        uPw1.focus();
    }
}


// 비밀번호가 맞는지 확인
function pwCheck2()
{
    let pw1 = uPw1.value;
    let pw2 = uPw2.value;
    if(pw1 != pw2)
    {
        alert("비밀번호가 일치하지 않습니다. 다시 확인해 주세요.");
        uPw2.value = "";
        uPw2.focus();
    }
}