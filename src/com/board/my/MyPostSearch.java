package com.board.my;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haeva.my.HaevaImpl;

import boardDAO.BoardDAO;
import boardVO.BoardVO;

public class MyPostSearch implements BoardImpl{

	@Override
	public void board(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BoardDAO bodao1 = null;
		ArrayList<BoardVO> Alist = null;
		ArrayList<BoardVO> Blist = null;
		ArrayList<BoardVO> Clist = null;
		
		bodao1 = new BoardDAO();
		
		String id = request.getParameter("id");
		int page1 = Integer.parseInt(request.getParameter("page1"));
		int page2 = Integer.parseInt(request.getParameter("page2"));
		int page3 = Integer.parseInt(request.getParameter("page3"));
		
		int maxpage1 = bodao1.getcount1(id);
		int maxpage2 = bodao1.getcount2(id);
		int maxpage3 = bodao1.getcount3(id);
		
		Alist = bodao1.searchMyPost1(id,page1);
		Blist = bodao1.searchMyPost2(id,page2);
		Clist = bodao1.searchMyPost3(id,page3);
		
		request.setAttribute("Alist", Alist);
		request.setAttribute("Blist", Blist);
		request.setAttribute("Clist", Clist);
		request.setAttribute("maxpage1", maxpage1);
		request.setAttribute("maxpage2", maxpage2);
		request.setAttribute("maxpage3", maxpage3);
		request.setAttribute("page1",page1);
		request.setAttribute("page2",page2);
		request.setAttribute("page3",page3);
		
	}

}
