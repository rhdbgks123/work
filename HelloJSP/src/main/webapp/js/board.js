
/**
 * board.js
 * 특정글의 댓글정보를 json으로 반환
 */

//board.jsp에서 const bno = "${board_info.boardNo }" 로 선언 필요
/*fetch('replyList.do?bno=' + bno)
.then(resolve => resolve.json())	//fetch의 결과값이 readableStream
.then(function(result)
{
	result.forEach(elem => 
	{
		let li = makeRow(elem);
		document.querySelector('div.content>ul').appendChild(li);	
	})
})
.catch(err => console.error(err));
*/

let page = 1; 
// 페이지 로딩시점에 실행
function showReplyList()
{	
	// 기존 목록을 지우고 새로 그려야함
	refreshReply();
	svc.replyList({bno, page}, 
		result => result.forEach(elem => document.querySelector('div.content>ul').appendChild(makeRow(elem))),
		err => console.error(err)
	);
}

showReplyList();
document.querySelector('#registerReply').addEventListener('click', registerReply);

function refreshReply()
{
	document.querySelectorAll('div.content>ul>li').forEach((elem, idx) =>
	{
		if(idx>=2) elem.remove();
	})
}

function makeRow(reply)
{
	let li = document.createElement('li');
	['replyNo', 'reply', 'replyer'].forEach(elem => 
	{
		let span = document.createElement('span');
		span.innerText = reply[elem];
		if(elem == 'reply')
		{
			span.setAttribute('class', 'col-sm-5')
		}
		else
		{
			span.setAttribute('class','col-sm-2');
		}
		li.appendChild(span);
	})
	let span = document.createElement('span');
	span.setAttribute('class','col-sm-2');
	let btn = document.createElement('button');
	btn.addEventListener('click',deleteRow);
	btn.innerText = '삭제';
	span.appendChild(btn);
	li.append(span);
	
	return li;
}
// 데이터 삭제
function deleteRow(e)
{
	let rno = e.target.parentElement.parentElement.children[0].innerText;
	if(!confirm(`${rno}번 댓글을 삭제하시겠습니까?`))
	{
		alert('삭제취소');
		return;
	}
	svc.removeReply(rno,	
		result => 
		{
			if(result.retCode == 'OK')
			{
				//e.target.parentElement.parentElement.remove();
				showReplyList();
			}
			else if (result.retCode == 'NG')
			{
				alert('댓글삭제 실패!');
			}
			else
			{
				alert('알수없는 오류 발생');	
			}
		},
		err => console.error(err)		
	)
}

function registerReply(e)
{
	// 게시글번호(bno) / 작성자(logId) / 댓글정보(reply)
	// bno, logId는 jsp에서 미리 선언되어있음
	let reply = document.querySelector('#reply').value;
	if(!bno || !reply || !logId) // js에서는 0, 공백, null, undefined는 false로 판단
	{
		alert("필수값 입력");
		return;
	}
	svc.registerReply({bno, reply, replyer : logId},
		(result => 
			{
				if(result.retCode == 'OK')
				{
					//document.querySelector('div.content>ul').appendChild(makeRow(result.retVal));	
					showReplyList();
				}
				else if(result.retCode = 'NG')
				{
					alert("처리중 예외발생");		
				}
				else
				{
					alert("알 수 없는 코드");	
				}
			}),
		err => console.error(err)
	)
		
}

//페이지 링크에 클릭 이벤트 등록

document.querySelectorAll('div.footer>div.pagination>a').forEach(atag =>
	{
		atag.addEventListener('click', e =>
		{
			e.preventDefault(); // a태그의 기본기능을 차단
			page = e.target.innerText;
			// 목록 그리기
			showReplyList();
		})
	}
	
)
