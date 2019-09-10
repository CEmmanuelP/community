package com.haeva.my;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boardDAO.BoardDAO;
import telinfoDAO.TelinfoDAO;
import telinfoVO.TelinfoVO;

public class HaevaTerminate implements HaevaImpl{

	@Override
	public boolean haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelinfoDAO tidao = null;
		BoardDAO bodao = null;
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		try {
			tidao = new TelinfoDAO();
			bodao = new BoardDAO();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		boolean res1 = tidao.pwChk(id,pw);
		
		HttpSession hs = request.getSession();

		if(res1 == true)
		{
			bodao.alldelete(id);
			tidao.terminate(id);
			return true;
		}
		else if(res1 == false)
		{
			hs.setAttribute("terminatechk", "Æ²¸²");
		}
		
		return res1;

		
	}

}
