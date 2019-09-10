package com.board.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardDAO.BoardDAO;
import boardVO.BoardVO;

public class Boardtitleinfo implements BoardImpl{

	@Override
	public void board(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BoardDAO bodao1 = null;
		BoardVO bv = null;
		
		bodao1 = new BoardDAO();
		
		String whatpost = request.getParameter("whatpost");
		String title = request.getParameter("title");
		
		if(whatpost.equals("A"))
		{
			bv = bodao1.gettitleInfo(title);
			request.setAttribute("whatp", "A");
		}
		if(whatpost.equals("B"))
		{
			bv = bodao1.gettitleInfo2(title);
			request.setAttribute("whatp", "B");
		}
		if(whatpost.equals("C"))
		{
			bv = bodao1.gettitleInfo3(title);
			request.setAttribute("whatp", "C");
		}
		
		request.setAttribute("title", title);
		request.setAttribute("sbv", bv);
		System.out.println(bv.getFilename());
	}

}
