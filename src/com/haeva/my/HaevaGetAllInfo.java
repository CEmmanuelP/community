package com.haeva.my;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import telinfoDAO.TelinfoDAO;
import telinfoVO.TelinfoVO;

public class HaevaGetAllInfo implements HaevaImpl{

	@Override
	public boolean haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TelinfoDAO tidao1 = null;
		
		try {
			tidao1 = new TelinfoDAO();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<TelinfoVO> alist1 = null;
//		try {
//			alist1 = tidao1.getAllInfo();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		
		request.setAttribute("alist1", alist1);
		
		return true;
	}
	
}
