package com.haeva.my;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import telinfoDAO.TelinfoDAO;

public class HaevaInsert implements HaevaImpl{

	@Override
	public boolean haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String jb1 = request.getParameter("jb1");
		String jb2 = request.getParameter("jb2");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String dob = request.getParameter("dob");
		String pn1 = request.getParameter("pn1");
		String pn2 = request.getParameter("pn2");
		String pn3 = request.getParameter("pn3");

	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date d2 = df.parse(dob);
		
	    
		TelinfoDAO tidao = null;
		
		tidao = new TelinfoDAO();
		System.out.println(d2);
		tidao.Insert(name,id,pw,new java.sql.Date(d2.getTime()),jb1,jb2,pn1,pn2,pn3);
		
		return true;

		
	}

}
