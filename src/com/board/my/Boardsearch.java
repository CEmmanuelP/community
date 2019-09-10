package com.board.my;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardDAO.BoardDAO;
import boardVO.BoardVO;

public class Boardsearch implements BoardImpl{

	@Override
	public void board(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BoardDAO bodao1 = null;
		ArrayList<BoardVO> alist1 = null;
		
		bodao1 = new BoardDAO();
		
		String whatpost = request.getParameter("whatpost");
		String search = request.getParameter("search");
		String kindsofsearch = request.getParameter("kindsofsearch");
		int page = Integer.parseInt(request.getParameter("page"));
		
		
		
		if(kindsofsearch != null)
		{
			request.setAttribute("search", search);
			request.setAttribute("kindsofsearch", kindsofsearch);
		}

		if(whatpost.equals("A"))
		{
			int maxpage = bodao1.getcount(search,kindsofsearch);
			
			alist1 = bodao1.searchinfo(kindsofsearch,search,page);
			
			request.setAttribute("alist1", alist1);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("page",page);
			request.setAttribute("whatp" , "A");
		}
		
		if(whatpost.equals("B"))
		{
			int maxpage = bodao1.getcount2(search,kindsofsearch);
			
			alist1 = bodao1.searchinfo2(kindsofsearch,search,page);
			
			request.setAttribute("alist1", alist1);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("page",page);
			request.setAttribute("whatp" , "B");
		}
		
		if(whatpost.equals("C"))
		{
			int maxpage = bodao1.getcount3(search,kindsofsearch);
			
			alist1 = bodao1.searchinfo3(kindsofsearch,search,page);
			
			request.setAttribute("alist1", alist1);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("page",page);
			request.setAttribute("whatp" , "C");
		}
	}

}
