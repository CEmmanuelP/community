package com.board.my;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardDAO.BoardDAO;
import boardVO.BoardVO;

public class Boardgetallinfo implements BoardImpl{

	@Override
	public void board(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BoardDAO bodao1 = null;
		
		String whatpost=request.getParameter("whatpost");
		int page = Integer.parseInt(request.getParameter("page"));
		
		try 
		{
			bodao1 = new BoardDAO();
		}
		catch( ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		
		ArrayList<BoardVO> alist1 = null;
		
		System.out.println(whatpost);
		
		if(whatpost.equals("A")) 
		{	
			int maxpage = bodao1.getcount();
			try
		{
			alist1 = bodao1.getAllInfo(page);
		}
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("alist1", alist1);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("page",page);
		}
		
		if(whatpost.equals("B")) {
			
			int maxpage = bodao1.getcount2();
			try
			{
				alist1 = bodao1.getAllInfo2(page);
			}
			catch( SQLException e)
			{
				e.printStackTrace();
			}
			request.setAttribute("alist1", alist1);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("page",page);
			}
		
		if(whatpost.equals("C")) {
			
			int maxpage = bodao1.getcount3();
			try
			{
				alist1 = bodao1.getAllInfo3(page);
			}
			catch( SQLException e)
			{
				e.printStackTrace();
			}
			request.setAttribute("alist1", alist1);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("page",page);
			}
		
	}

}
