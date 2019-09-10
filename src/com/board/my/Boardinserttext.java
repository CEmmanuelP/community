package com.board.my;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import boardDAO.BoardDAO;
import boardVO.BoardVO;

public class Boardinserttext extends HttpServlet implements BoardImpl{

	@Override
	public void board(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ServletContext context = request.getSession().getServletContext();
		String saveDir = context.getRealPath("Save");
		System.out.println("절대경로>>"+saveDir);
		System.out.println(saveDir);
		
		int maxsize = 10*1024*1024; //3MB
		
		String encoding = "UTF-8";
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxsize, encoding, new DefaultFileRenamePolicy());
		

		
		BoardDAO bodao1 = null;
		bodao1 = new BoardDAO();
		System.out.println("bodao1 선언");
		ArrayList<BoardVO> alist1 = null;

	
		String id =multi.getParameter("id");
		System.out.println(id);
		
		String whatpost = multi.getParameter("whatpost");
		System.out.println("이건 왓" + whatpost);
//		
//		alist1 = bodao1.getAllInfo2(1);
//		
//		int board_id = 1;
//		
//		if(alist1.size() > 0)
//			board_id = alist1.get(0).getBoard_id()+1;
		
		String title = multi.getParameter("title");
		System.out.println(title);
		String text = multi.getParameter("text");
		System.out.println(text);
		String file = multi.getFilesystemName("file");
		System.out.println(file);
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String d = df.format(today);
		Date d2 = df.parse(d);
		

		
		if(whatpost.equals("A")) 
		{
			alist1 = bodao1.getAllInfo(1);
			
			int board_id = 1;
			
			if(alist1.size() > 0)
				board_id = alist1.get(0).getBoard_id()+1;
			
			bodao1.insert_text(id,board_id,title,text,file, new java.sql.Date(d2.getTime()));
			request.setAttribute("whatp" , "A");
		}
		if(whatpost.equals("B")) 
		{
			alist1 = bodao1.getAllInfo2(1);
			
			int board_id = 1;
			
			if(alist1.size() > 0)
				board_id = alist1.get(0).getBoard_id()+1;
			
			bodao1.insert_text2(id,board_id,title,text,file, new java.sql.Date(d2.getTime()));	
			request.setAttribute("whatp" , "B");
		}
		if(whatpost.equals("C")) 
		{
			alist1 = bodao1.getAllInfo3(1);
			
			int board_id = 1;
			
			if(alist1.size() > 0)
				board_id = alist1.get(0).getBoard_id()+1;
			
			bodao1.insert_text3(id,board_id,title,text,file, new java.sql.Date(d2.getTime()));	
			request.setAttribute("whatp" , "C");
		}
		
		
		
	}

}
