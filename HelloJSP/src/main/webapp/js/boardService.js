/**
 * boardService.js
 */

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
	}
}