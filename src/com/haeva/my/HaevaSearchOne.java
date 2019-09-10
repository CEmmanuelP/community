package com.haeva.my;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import telinfoDAO.TelinfoDAO;
import telinfoVO.TelinfoVO;

public class HaevaSearchOne implements HaevaImpl{

	@Override
	public boolean haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelinfoDAO tidao1 = null;
		TelinfoVO tv = null;
		
		try {
			tidao1 = new TelinfoDAO();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		
		try {
			tv = tidao1.getInfo(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("sid", id);
		request.setAttribute("stv", tv);
		
		return true;
		
	}

}
