package com.haeva.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import telinfoDAO.TelinfoDAO;

public class HaevaMemberChk implements HaevaImpl{

	@Override
	public boolean haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String jb1 = request.getParameter("jb1");
		String jb2 = request.getParameter("jb2");
		
		TelinfoDAO tidao = null;
		
		tidao = new TelinfoDAO();
		
		boolean res = tidao.memberChk(name,jb1,jb2);
		
		HttpSession hs = request.getSession();
		
		if(res) 
		{
			hs.setAttribute("name", name);
			hs.setAttribute("jb1", jb1);
			hs.setAttribute("jb2", jb2);
		}
		else if(res == false)
		{
			hs.setAttribute("memberchk", "¿÷¿Ω");
		}
		
		return res;
	}

}
