package com.board.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardImpl {
	public void board(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//메소드인데 중괄호가 없음 왜냐 인터페이스라서 인터페이스는 실제가 아닌 가상 클래스 개념인지라 메소드가 있을수 없음
	//선언만 가능하고 구현은 자식에서 해야함

}
