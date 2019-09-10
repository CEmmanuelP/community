package com.haeva.my;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import telinfoDAO.TelinfoDAO;
import telinfoVO.TelinfoVO;

public class HaevaUpdate implements HaevaImpl{

	@Override
	public boolean haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelinfoDAO tidao1 = null;
		TelinfoVO tv = null;
		
		
		  String id=request.getParameter("id");
		/*
		 * String name = request.getParameter("name"); String pn =
		 * request.getParameter("pn"); String dob = request.getParameter("dob");
		 */
		 
		String pw=request.getParameter("pw");
	
		/* String change_pw = request.getParameter("change_pw"); */
	
		try {
			tidao1 = new TelinfoDAO();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		boolean res = tidao1.update_passward(pw,id);
		System.out.println(pw);
		System.out.println(id);
		
		return res;
		
		
		
	}

}
