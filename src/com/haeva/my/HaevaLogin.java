package com.haeva.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import telinfoDAO.TelinfoDAO;

public class HaevaLogin implements HaevaImpl{

	@Override
	public boolean haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("ID");
		String pw = request.getParameter("pw");

		TelinfoDAO tidao = null;
		
		tidao = new TelinfoDAO();
		
		boolean res = tidao.Login(id,pw);
		
		HttpSession hs = request.getSession();
		
		if(res) 
		{	
			hs.setAttribute("id", id);
		}
		else if(res == false)
		{
			hs.setAttribute("loginchk", "Æ²¸²");
		}
		
		return res;
	}

}
