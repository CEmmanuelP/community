package com.board.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardDAO.BoardDAO;

public class Boarddelete implements BoardImpl{

	@Override
	public void board(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		BoardDAO bodao = null;
		
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String whatpost = request.getParameter("whatpost");
		
		bodao = new BoardDAO();
		
		if(whatpost.equals("A"))
		{
			bodao.delete(board_id);
			request.setAttribute("whatp" , "A");
		}
		if(whatpost.equals("B"))
		{
			bodao.delete2(board_id);
			request.setAttribute("whatp" , "B");
		}
		if(whatpost.equals("C"))
		{
			bodao.delete3(board_id);
			request.setAttribute("whatp" , "C");
		}
		
		
	}

}
