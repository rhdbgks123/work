package com.yedam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface Controller{
	public void exe();
}

class Sample implements Controller{

	@Override
	public void exe() {
		System.out.println("Sample 클래스 exe메소드");
		
	}
	
}

public class Main {

	public static void main(String[] args) {

//		BoardService svc = new BoardServiceImpl();

		
//		SqlSession session = DBUtil.getInstance().openSession();
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		List<BoardVO> list = mapper.selectList();
//		
//		for(BoardVO board : list)
//			System.out.println(board.toString());
			
//		
//		BoardVO board = mapper.selectBoard(1);
//		mapper.updateCount(searchNo);
//		System.out.println(board.toString());
		
//		int searchNo = 1;
//		BoardVO board = svc.searchBoard(searchNo);
//		System.out.println(board.toString());
		
		
		ArrayList<Book> list = new ArrayList<>();
		// list.get = ArrayList의 n번째 값 반환
//		Book book = list.get(0);
		// 키 = 값 키는 String, 값은 Integer인 경우
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("홍길동", 80);
		map.put("박길동", 78);
		
		Integer result = map.get("홍길동");
		System.out.println(result);
		System.out.println(map.get("박길동"));
		// 오른쪽에 <> 안에는 값을 안적어줘도 왼쪽 값을 가져옴
		Map<String, Controller> controls = new HashMap<>();
		controls.put("Sample", new Sample());
		controls.put("test", new Controller() {

			@Override
			public void exe() {
				System.out.println("test 출력");
				
			}
			
		});
		Controller val = controls.get("Sample");
		val.exe();
		controls.get("test").exe();
		
	}

}
