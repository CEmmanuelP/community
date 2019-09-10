package com.frontcontroller.my;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.my.BoardImpl;
import com.board.my.Boarddelete;
import com.board.my.Boardgetallinfo;
import com.board.my.Boardinserttext;
import com.board.my.Boardsearch;
import com.board.my.Boardtitleinfo;
import com.board.my.Boardupdate;
import com.board.my.MyPostSearch;
import com.haeva.my.HaevaTerminate;
import com.haeva.my.HaevaGetAllInfo;
import com.haeva.my.HaevaIdChk;
import com.haeva.my.HaevaIdFind;
import com.haeva.my.HaevaImpl;
import com.haeva.my.HaevaInsert;
import com.haeva.my.HaevaLogin;
import com.haeva.my.HaevaMemberChk;
import com.haeva.my.HaevaPwFind;
import com.haeva.my.HaevaSearchOne;
import com.haeva.my.HaevaUpdate;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import boardDAO.BoardDAO;
import boardVO.BoardVO;

/**
 * Servlet implementation class Sawonfrontcontroller
 */
//@WebServlet("/Sawonfrontcontroller")
@WebServlet("*.do") 
public class Sawonfrontcontroller extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sawonfrontcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      /*response.getWriter().append("Served at: ").append(request.getContextPath());*/
      
      ///////////////////////////////////////////////////////
      String ru1 = request.getRequestURI();
      System.out.println(ru1);
      
      String cp1 = request.getContextPath();
      System.out.println(cp1);
      String c1 = ru1.substring(cp1.length());
      System.out.println(c1);
      /////////////////////////////////////////////////////////
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      
      String c = request.getRequestURI().substring(request.getContextPath().length());
      
      String str = null;

      
      HaevaImpl scmd1 = null;
      BoardImpl scmd2 = null;
      
      
      boolean res;

      
      switch(c) 
      {
      case "/getAllInfo.do":
         scmd1 = new HaevaGetAllInfo();
         try {
            scmd1.haeva(request, response);
         }catch(Exception e) {
            e.printStackTrace();
         }
         str = "getAllInfo.jsp";
         break;
         
      case "/memberChk.do":
         scmd1 = new HaevaMemberChk();
         try {
            res = scmd1.haeva(request, response);
            if(res) {
               str="idChk.jsp";
            }else {
               str="memberChk.jsp";
            }
         }catch(Exception e) {
            e.printStackTrace();
         }
         break;
         
      case "/idChk.do":
         scmd1 = new HaevaIdChk();
         try {
            res = scmd1.haeva(request, response);
            if(res) {
               str="member.jsp";
            }else {
               str="idChk.jsp";
            }
         }catch(Exception e) {
            e.printStackTrace();
         }
         break;
         
      case "/idFind.do":
         scmd1 = new HaevaIdFind();
         try {
            res = scmd1.haeva(request, response);
            if(!res) {
               str="answer_Id.jsp";
            }else {
               str="find_Id.jsp";
            }
         }catch(Exception e) {
            e.printStackTrace();
         }
         break;
      
      case "/pwFind.do":
         scmd1 = new HaevaPwFind();
         try {
            res = scmd1.haeva(request, response);
            if(!res) {
               str="answer_Pw.jsp";
            }else {
               str="find_Pw.jsp";
            }
         }catch(Exception e) {
            e.printStackTrace();
         }
         break;
         
      case "/login.do":
         scmd1 = new HaevaLogin();
         try {
            res = scmd1.haeva(request, response);
            if(res) {
               str="counter.jsp";
            }else {
               str="login.jsp";
            }
         } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         break;
         
      case "/Insert.do":
         scmd1 = new HaevaInsert();
         try {
            scmd1.haeva(request, response);
         }catch(Exception e) {
            e.printStackTrace();
         }
         str="login.jsp";
         break;
         
      case "/terminate.do":
         scmd1 = new HaevaTerminate();
         try {
            res = scmd1.haeva(request, response);
            if(res == true)
            {
               str="terminate_check.jsp";
            }
            else if(res == false)
            {
               str="terminate.jsp";
            }
         }catch(Exception e) {
            e.printStackTrace();
         }
         break;
         
/*      case "/telUpdate.do":
         scmd1 = new HaevaUpdate();
         try {
            scmd1.haeva(request, response);
         }catch(Exception e) {
            e.printStackTrace();
         }
         str="getAllInfo.jsp";
         break;
         
      case "/telDelete.do":
         scmd1 = new HaevaDelete();
         try {
            scmd1.haeva(request, response);
         }catch(Exception e) {
            e.printStackTrace();
         }
         str="getAllInfo.jsp";
         break;*/

         
         /*-----------------------------------------------------*/
         
      case "/getAllInfo2.do" :
         scmd2 = new Boardgetallinfo();
         try {
            scmd2.board(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         String whatpost=request.getParameter("whatpost");
         if(whatpost.equals("A")) 
         {
            str = "Apost_list_page.jsp";
         }
         if(whatpost.equals("B")) 
         {
            str = "Bpost_list_page.jsp";
         }
         if(whatpost.equals("C")) 
         {
            str = "Cpost_list_page.jsp";
         }
         break;
         
      /*case "/getAllInfo3.do" :
         scmd2 = new Boardgetallinfo();
         try {
            scmd2.board(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         str = "Bpost_list_page.jsp";
         break;
         
      case "/getAllInfo4.do" :
         scmd2 = new Boardgetallinfo();
         try {
            scmd2.board(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         str = "Cpost_list_page.jsp";
         break;*/
         
      case "/titleinfo.do" :
         scmd2 = new Boardtitleinfo();
         try {
            scmd2.board(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         String whatpost4=request.getParameter("whatpost");
         String search = request.getParameter("search");
         String kindsofsearch = request.getParameter("kindsofsearch");
         int page = Integer.parseInt(request.getParameter("page"));
         
         if(whatpost4.equals("A"))
         {
            if(search.equals(""))
               str = "getAllInfo2.do?page="+page+"&whatpost=A";
            else
            {   
               System.out.println("검색 결과 : ");
               System.out.println("검색 내용 : " + search);
               System.out.println("검색 뭐시기 : " + kindsofsearch);
               System.out.println("페이지 : " + page);
               str = "search.do?page="+page+"&kindsofsearch="+kindsofsearch+"&search="+search+"&whatpost=A";
            }
         }
         if(whatpost4.equals("B"))
         {
            if(search.equals(""))
               str = "getAllInfo2.do?page="+page+"&whatpost=B";
            else
               str = "search.do?page="+page+"&kindsofsearch="+kindsofsearch+"&search="+search+"&whatpost=B";
         }
         if(whatpost4.equals("C"))
         {
            if(search.equals(""))
               str = "getAllInfo2.do?page="+page+"&whatpost=C";
            else
               str = "search.do?page="+page+"&kindsofsearch="+kindsofsearch+"&search="+search+"&whatpost=C";
         }

         break;
         
      case "/inserttext.do" :
         scmd2=new Boardinserttext();
         try {
            scmd2.board(request, response);
         } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         String whatpost2 = (String) request.getAttribute("whatp");
         System.out.println("나는 what2 : " + whatpost2);
         if(whatpost2.equals("A")) 
         {
            str = "getAllInfo2.do?page=1&whatpost=A";
         }
         if(whatpost2.equals("B")) 
         {
            str = "getAllInfo2.do?page=1&whatpost=B";
         }
         if(whatpost2.equals("C")) 
         {
            str = "getAllInfo2.do?page=1&whatpost=C";
         }
         break;
         
      case "/search.do" :
         scmd2 = new Boardsearch();
         try {
            scmd2.board(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         String whatpost3 = (String) request.getAttribute("whatp");
         System.out.println("나는 what2 : " + whatpost3);
         if(whatpost3.equals("A")) 
         {
            str = "Apost_list_page.jsp";
         }
         if(whatpost3.equals("B")) 
         {
            str = "Bpost_list_page.jsp";
         }
         if(whatpost3.equals("C")) 
         {
            str = "Cpost_list_page.jsp";
         }
         break;
         
      case "/mypost.do" :
         scmd2 = new MyPostSearch();
         try {
            scmd2.board(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         str = "mypage.jsp";
         break;
         
      case "/mypage.do" :
         scmd1 = new HaevaSearchOne();
         try {
            res=scmd1.haeva(request, response);
            if(res) {
               str="mypage.jsp";
            }
            else {
               System.out.println("마이페이지 에러");
            }
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         break;
         
      case "/change_passward.do" :
         scmd1 = new HaevaUpdate();
         try {
            res=scmd1.haeva(request, response);
            if(res) {
               str="mainpage.jsp";
               System.out.println(res);
            }
            else {
               System.out.println("passward error");
            }
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         break;
         
      case "/updatepost.do" :
         scmd2 = new Boardupdate();
         try {
            scmd2.board(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         String whatpost6= (String) request.getAttribute("whatp");
         if(whatpost6.equals("A")) 
         {
            str = "getAllInfo2.do?page=1&whatpost=A";
         }
         if(whatpost6.equals("B")) 
         {
            str = "getAllInfo2.do?page=1&whatpost=B";
         }
         if(whatpost6.equals("C")) 
         {
            str = "getAllInfo2.do?page=1&whatpost=C";
         }
         break;
         
      case "/deletepost.do" :
         scmd2 = new Boarddelete();
         try {
            scmd2.board(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         String whatpost5= (String) request.getAttribute("whatp");

         if(whatpost5.equals("A")) 
         {
            str = "getAllInfo2.do?page=1&whatpost=A";
         }
         if(whatpost5.equals("B")) 
         {
            str = "getAllInfo2.do?page=1&whatpost=B";
         }
         if(whatpost5.equals("C")) 
         {
            str = "getAllInfo2.do?page=1&whatpost=C";
         }
         break;

         
      }
      
      RequestDispatcher rd1 = request.getRequestDispatcher(str);
      rd1.forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
   }

}