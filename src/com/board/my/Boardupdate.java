package com.board.my;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import boardDAO.BoardDAO;

public class Boardupdate extends HttpServlet  implements BoardImpl{

   @Override
   public void board(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      ServletContext context = request.getSession().getServletContext();
      String saveDir = context.getRealPath("Save");
      
      int maxsize = 3*1024*1024; //3MB
      
      String encoding = "UTF-8";
      

      
      MultipartRequest multi = new MultipartRequest(request, saveDir, maxsize, encoding, new DefaultFileRenamePolicy());
      
      BoardDAO bodao1 = null;
      bodao1 = new BoardDAO();

      String title = multi.getParameter("title");
      String text = multi.getParameter("text");
      int board_id = Integer.parseInt(multi.getParameter("board_id"));
      String file = multi.getFilesystemName("file");
      String whatpost = multi.getParameter("whatpost");
      
      if(whatpost.equals("A"))
      {
          if(file==null)
          {
             bodao1.updatetext(title, text, board_id);
          }
          else
          {
             bodao1.updatefile(title, text, file, board_id);
          }
          request.setAttribute("whatp", "A");
      }
      if(whatpost.equals("B"))
      {
          if(file==null)
          {
             bodao1.updatetext2(title, text, board_id);
          }
          else
          {
             bodao1.updatefile2(title, text, file, board_id);
          }
          request.setAttribute("whatp", "B");
      }
      if(whatpost.equals("C"))
      {
          if(file==null)
          {
             bodao1.updatetext3(title, text, board_id);
          }
          else
          {
             bodao1.updatefile3(title, text, file, board_id);
          }
          request.setAttribute("whatp", "C");
      }   
   }

}