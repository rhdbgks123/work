/**
 * boardService.js
 */

class PageVO
{
	//생성자
	constructor(currPage, totalCnt)
	{
		this.currPage = currPage;
		this.totalCnt = totalCnt;
		this.end = Math.ceil(currPage / 10) * 10; // 10개씩 보여주기
		this.start = this.end - 9;
		
		let realEnd = Math.ceil(totalCnt / 5); // 한페이지당 5개씩 보여주기
		this.end = this.end > realEnd ? realEnd : this.end;
		this.prev = this.start > 1 ;
		this.next = this.end < realEnd;
	}	
	
}


const svc = 
{
	count:20,
	increaseCount:function()
	{
		this.count++;
	},
	showCount(){
		return this.count;
	},
	// 목록 ajax 메소드
	replyList(param ={bno, page : 1}, successCallback, errorCallback)
	{
		fetch('replyList.do?bno=' + param.bno + '&page=' + param.page)
		.then(resolve => resolve.json())	//fetch의 결과값이 readableStream
		.then(successCallback)
		.catch(errorCallback);
	},
	// 삭제 ajax
	removeReply(rno, successCallback, errorCallback)
	{
	// fetch 서버프로그램 호출
		fetch('removeReply.do?rno=' + rno)
		.then(resolve => resolve.json())	//fetch의 결과값이 readableStream
		.then(successCallback)
		.catch(errorCallback);
	},
	// 등록 ajax
	registerReply(param = {bno, reply, replyer}, successCallback, errorCallback)
	{
		fetch('registerReply.do?bno='+ param.bno +'&reply=' + param.reply + '&replyer=' + param.replyer)
		.then(resolve => resolve.json())	
		.then(successCallback)
		.catch(errorCallback);
	},
	replyTotalCount(bno, successCallback, errorCallback)
	{
		fetch('totalReply.do?bno='+ bno)
		.then(resolve => resolve.json())	
		.then(successCallback)
		.catch(errorCallback);
	}
}