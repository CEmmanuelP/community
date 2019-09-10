package boardDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import boardVO.BoardVO;
import telinfoDBConn.TelinfoDBConn;

public class BoardDAO {
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BoardDAO() throws ClassNotFoundException, SQLException
	{
		con = new TelinfoDBConn().getConnection();
	}
	
	public void pstmtClose() throws SQLException
	{
		if(pstmt != null)
		{
			pstmt.close();
		}
	}
	
	public void getAllInfoClose() throws SQLException
	{
		if(rs != null)
		{
			rs.close();
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(con != null)
		{
			con.close();
		}
	}
	
	public int getcount() throws SQLException
	{
		String sql = "select count(board_id) from board";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int num = 0;
		if(rs.next())
		{
			num = rs.getInt("count(board_id)");
		}
		int num2 = ((num-1)/10)+1;
		
		return num2;
	}
	public int getcount2() throws SQLException
	{
		String sql = "select count(board_id) from board2";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int num = 0;
		if(rs.next())
		{
			num = rs.getInt("count(board_id)");
		}
		int num2 = ((num-1)/10)+1;
		
		return num2;
	}
	public int getcount3() throws SQLException
	{
		String sql = "select count(board_id) from board3";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int num = 0;
		if(rs.next())
		{
			num = rs.getInt("count(board_id)");
		}
		int num2 = ((num-1)/10)+1;
		
		return num2;
	}
	
	
	public int getcount(String search1 , String kindsofsearch1) throws SQLException
	{
		String sql = null;
		if("게시물 제목".equals(kindsofsearch1))
			sql = "select count(board_id) from board where title like ?";
		else if("작성자 이름".equals(kindsofsearch1))
			sql = "select count(board_id) from board where id like ?";
		
		pstmt = con.prepareStatement(sql);
		String search3 = "%" + search1 + "%"; 
		pstmt.setString(1, search3);
		rs = pstmt.executeQuery();
		
		int num = 0;
		if(rs.next())
		{
			num = rs.getInt("count(board_id)");
		}
		int num2 = ((num-1)/10)+1;
		
		return num2;
	}
	public int getcount2(String search1 , String kindsofsearch1) throws SQLException
	{
		String sql = null;
		if("게시물 제목".equals(kindsofsearch1))
			sql = "select count(board_id) from board2 where title like ?";
		else if("작성자 이름".equals(kindsofsearch1))
			sql = "select count(board_id) from board2 where id like ?";
		
		pstmt = con.prepareStatement(sql);
		String search3 = "%" + search1 + "%"; 
		pstmt.setString(1, search3);
		rs = pstmt.executeQuery();
		
		int num = 0;
		if(rs.next())
		{
			num = rs.getInt("count(board_id)");
		}
		int num2 = ((num-1)/10)+1;
		
		return num2;
	}
	public int getcount3(String search1 , String kindsofsearch1) throws SQLException
	{
		String sql = null;
		if("게시물 제목".equals(kindsofsearch1))
			sql = "select count(board_id) from board3 where title like ?";
		else if("작성자 이름".equals(kindsofsearch1))
			sql = "select count(board_id) from board3 where id like ?";
		
		pstmt = con.prepareStatement(sql);
		String search3 = "%" + search1 + "%"; 
		pstmt.setString(1, search3);
		rs = pstmt.executeQuery();
		
		int num = 0;
		if(rs.next())
		{
			num = rs.getInt("count(board_id)");
		}
		int num2 = ((num-1)/10)+1;
		
		return num2;
	}
	
	public int getcount1(String id) throws SQLException
	{
		String sql = null;
		sql = "select count(board_id) from board where id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		int num = 0;
		if(rs.next())
		{
			num = rs.getInt("count(board_id)");
		}
		int num2 = ((num-1)/10)+1;
		
		return num2;
	}
	
	public int getcount2(String id) throws SQLException
	{
		String sql = null;
		sql = "select count(board_id) from board2 where id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		int num = 0;
		if(rs.next())
		{
			num = rs.getInt("count(board_id)");
		}
		int num2 = ((num-1)/10)+1;
		
		return num2;
	}
	
	public int getcount3(String id) throws SQLException
	{
		String sql = null;
		sql = "select count(board_id) from board3 where id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		int num = 0;
		if(rs.next())
		{
			num = rs.getInt("count(board_id)");
		}
		int num2 = ((num-1)/10)+1;
		
		return num2;
	}
	   public boolean updatefile(String title1,String text1,String file1,int board_id1)
	   {
	      String sql = "update Board set title = ? , text = ? , filename = ? where board_id = ?";
	   
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, title1);
	         pstmt.setString(2, text1);
	         pstmt.setString(3, file1);
	         pstmt.setInt(4, board_id1);

	         pstmt.executeUpdate();
	      }
	      catch(SQLException e)
	      {
	         System.out.println("update Exception");
	         return false;
	      }
	      return true;
	   }
	   
	   public boolean updatefile2(String title1,String text1,String file1,int board_id1)
	   {
	      String sql = "update Board2 set title = ? , text = ? , filename = ? where board_id = ?";
	   
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, title1);
	         pstmt.setString(2, text1);
	         pstmt.setString(3, file1);
	         pstmt.setInt(4, board_id1);

	         pstmt.executeUpdate();
	      }
	      catch(SQLException e)
	      {
	         System.out.println("update Exception");
	         return false;
	      }
	      return true;
	   }
	   
	   public boolean updatefile3(String title1,String text1,String file1,int board_id1)
	   {
	      String sql = "update Board3 set title = ? , text = ? , filename = ? where board_id = ?";
	   
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, title1);
	         pstmt.setString(2, text1);
	         pstmt.setString(3, file1);
	         pstmt.setInt(4, board_id1);

	         pstmt.executeUpdate();
	      }
	      catch(SQLException e)
	      {
	         System.out.println("update Exception");
	         return false;
	      }
	      return true;
	   }
	   
	   public boolean updatetext(String title1,String text1,int board_id1)
	   {
	      String sql = "update Board set title = ? , text = ? where board_id = ?";
	   
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, title1);
	         pstmt.setString(2, text1);
	         pstmt.setInt(3, board_id1);

	         pstmt.executeUpdate();
	      }
	      catch(SQLException e)
	      {
	         System.out.println("update Exception");
	         return false;
	      }
	      return true;
	   }
	   
	   public boolean updatetext2(String title1,String text1,int board_id1)
	   {
	      String sql = "update Board2 set title = ? , text = ? where board_id = ?";
	   
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, title1);
	         pstmt.setString(2, text1);
	         pstmt.setInt(3, board_id1);

	         pstmt.executeUpdate();
	      }
	      catch(SQLException e)
	      {
	         System.out.println("update Exception");
	         return false;
	      }
	      return true;
	   }
	   
	   public boolean updatetext3(String title1,String text1,int board_id1)
	   {
	      String sql = "update Board3 set title = ? , text = ? where board_id = ?";
	   
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, title1);
	         pstmt.setString(2, text1);
	         pstmt.setInt(3, board_id1);

	         pstmt.executeUpdate();
	      }
	      catch(SQLException e)
	      {
	         System.out.println("update Exception");
	         return false;
	      }
	      return true;
	   }
	
	public ArrayList<BoardVO> getAllInfo(int page) throws SQLException
	{
		ArrayList<BoardVO> boarray = new ArrayList<BoardVO>();
		
		String sql2 = "select count(id) from board";
		pstmt = con.prepareStatement(sql2);
		rs = pstmt.executeQuery();
		int num=0;
	
		if(rs.next())
		{
			num = rs.getInt("count(id)");
			System.out.println("num : " + num);
		}
		int num2 = ((num-1)/10)+1;
		
		for(int i=1 ; i<=num2 ; i++)
		{
			if(page == i)
			{
				String sql = "select * from (select B.* , rownum as R from (select * from Board order by board_id desc) B where rownum <= ?) where R >= ?";
				pstmt = con.prepareStatement(sql);
				
				if((((page-1)*10)+10) > num)
					pstmt.setInt(1, num);
				else
					pstmt.setInt(1, ((page-1)*10)+10);
				
				pstmt.setInt(2, ((page-1)*10)+1);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					String id = rs.getString("id");
					int board_id = rs.getInt("board_id");
//					String id = rs.getString("id");
					String title = rs.getString("title");
					String text = rs.getString("text");
					Date d = rs.getDate("d");
					String filename = rs.getString("filename");
					//import util아님 sql임
					
					BoardVO tv = new BoardVO(id,board_id,title,text,d,filename);
					boarray.add(tv);
				}
			}
		}
		

		return boarray;
	}
	public ArrayList<BoardVO> getAllInfo2(int page) throws SQLException
	{
		ArrayList<BoardVO> boarray = new ArrayList<BoardVO>();
		
		String sql2 = "select count(id) from board2";
		pstmt = con.prepareStatement(sql2);
		rs = pstmt.executeQuery();
		int num=0;
	
		if(rs.next())
		{
			num = rs.getInt("count(id)");
		}
		int num2 = ((num-1)/10)+1;
		
		for(int i=1 ; i<=num2 ; i++)
		{
			if(page == i)
			{
				String sql = "select * from (select B.* , rownum as R from (select * from Board2 order by board_id desc) B where rownum <= ?) where R >= ?";
				pstmt = con.prepareStatement(sql);
				
				if((((page-1)*10)+10) > num)
					pstmt.setInt(1, num);
				else
					pstmt.setInt(1, ((page-1)*10)+10);
				
				pstmt.setInt(2, ((page-1)*10)+1);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					String id = rs.getString("id");
					int board_id = rs.getInt("board_id");
//					String id = rs.getString("id");
					String title = rs.getString("title");
					String text = rs.getString("text");
					Date d = rs.getDate("d");
					String filename = rs.getString("filename");
					//import util아님 sql임
					
					BoardVO tv = new BoardVO(id,board_id,title,text,d,filename);
					boarray.add(tv);
				}
			}
		}
		

		return boarray;
	}
	public ArrayList<BoardVO> getAllInfo3(int page) throws SQLException
	{
		ArrayList<BoardVO> boarray = new ArrayList<BoardVO>();
		
		String sql2 = "select count(id) from board3";
		pstmt = con.prepareStatement(sql2);
		rs = pstmt.executeQuery();
		int num=0;
	
		if(rs.next())
		{
			num = rs.getInt("count(id)");
		}
		int num2 = ((num-1)/10)+1;
		
		for(int i=1 ; i<=num2 ; i++)
		{
			if(page == i)
			{
				String sql = "select * from (select B.* , rownum as R from (select * from Board3 order by board_id desc) B where rownum <= ?) where R >= ?";
				pstmt = con.prepareStatement(sql);
				
				if((((page-1)*10)+10) > num)
					pstmt.setInt(1, num);
				else
					pstmt.setInt(1, ((page-1)*10)+10);
				
				pstmt.setInt(2, ((page-1)*10)+1);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					String id = rs.getString("id");
					int board_id = rs.getInt("board_id");
//					String id = rs.getString("id");
					String title = rs.getString("title");
					String text = rs.getString("text");
					Date d = rs.getDate("d");
					String filename = rs.getString("filename");
					//import util아님 sql임
					
					BoardVO tv = new BoardVO(id,board_id,title,text,d,filename);
					boarray.add(tv);
				}
			}
		}
		

		return boarray;
	}
	
	public BoardVO gettitleInfo(String title1) throws SQLException
	{
		BoardVO tv=null;
		String sql = "select * from board where title=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title1);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			String id = rs.getString("id");
			int board_id = rs.getInt("board_id");
			String title = rs.getString("title");
			String text = rs.getString("text");
			Date d = rs.getDate("d");
			String filename = rs.getString("filename");

			tv = new BoardVO(id,board_id,title,text,d,filename);
		}
		else
		{
			tv = null;
		}
		return tv;
	}
	
	public BoardVO gettitleInfo2(String title1) throws SQLException
	{
		BoardVO tv=null;
		String sql = "select * from board2 where title=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title1);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			String id = rs.getString("id");
			int board_id = rs.getInt("board_id");
			String title = rs.getString("title");
			String text = rs.getString("text");
			Date d = rs.getDate("d");
			String filename = rs.getString("filename");

			tv = new BoardVO(id,board_id,title,text,d,filename);
		}
		else
		{
			tv = null;
		}
		return tv;
	}
	
	public BoardVO gettitleInfo3(String title1) throws SQLException
	{
		BoardVO tv=null;
		String sql = "select * from board3 where title=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title1);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			String id = rs.getString("id");
			int board_id = rs.getInt("board_id");
			String title = rs.getString("title");
			String text = rs.getString("text");
			Date d = rs.getDate("d");
			String filename = rs.getString("filename");

			tv = new BoardVO(id,board_id,title,text,d,filename);
		}
		else
		{
			tv = null;
		}
		return tv;
	}
	
	public boolean insert_text(String id1 , int board_id1 , String title1 , String text1 ,String file, Date d1)
	{
		String sql = "insert into board "
				   + "values(?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			System.out.println("시");
			pstmt.setString(1, id1);
			pstmt.setInt(2, board_id1);
			pstmt.setString(3, title1);
			pstmt.setString(4, text1);
			
			/*pstmt.setDate(4, d2);*/
//			int year = Integer.parseInt(d1.substring(0,4))-1900;
//			int month= Integer.parseInt(d1.substring(4,6))-1;
//			int day  = Integer.parseInt(d1.substring(6,8));
//			Date d = new Date(year,month,day);
			pstmt.setDate(5, d1);
			pstmt.setString(6, file);
			System.out.println("작");
			

			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.getStackTrace();
			System.out.println("insert Exception");
			return false;
		}
		return true;
	}
	
	public boolean insert_text2(String id1 , int board_id1 , String title1 , String text1 ,String file, Date d1)
	{
		String sql = "insert into board2 "
				   + "values(?,?,?,?,?,?)";
		
		System.out.println("----------------------");
		System.out.println(id1);
		System.out.println(board_id1);
		System.out.println(title1);
		System.out.println(text1);
		System.out.println(file);
		System.out.println(d1);
		System.out.println("----------------------");
		
		
		try {
			pstmt=con.prepareStatement(sql);
			System.out.println("시");
			pstmt.setString(1, id1);
			pstmt.setInt(2, board_id1);
			pstmt.setString(3, title1);
			pstmt.setString(4, text1);
			
			/*pstmt.setDate(4, d2);*/
//			int year = Integer.parseInt(d1.substring(0,4))-1900;
//			int month= Integer.parseInt(d1.substring(4,6))-1;
//			int day  = Integer.parseInt(d1.substring(6,8));
//			Date d = new Date(year,month,day);
			pstmt.setDate(5, d1);
			pstmt.setString(6, file);
			System.out.println("작");
			

			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.getStackTrace();
			System.out.println("insert Exception");
			return false;
		}
		return true;
	}
	public boolean insert_text3(String id1 , int board_id1 , String title1 , String text1 ,String file, Date d1)
	{
		String sql = "insert into board3 "
				   + "values(?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			System.out.println("시");
			pstmt.setString(1, id1);
			pstmt.setInt(2, board_id1);
			pstmt.setString(3, title1);
			pstmt.setString(4, text1);
			
			/*pstmt.setDate(4, d2);*/
//			int year = Integer.parseInt(d1.substring(0,4))-1900;
//			int month= Integer.parseInt(d1.substring(4,6))-1;
//			int day  = Integer.parseInt(d1.substring(6,8));
//			Date d = new Date(year,month,day);
			pstmt.setDate(5, d1);
			pstmt.setString(6, file);
			System.out.println("작");
			

			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.getStackTrace();
			System.out.println("insert Exception");
			return false;
		}
		return true;
	}
	
	public ArrayList<BoardVO> searchinfo(String kindsofsearch1 , String search1 , int page) throws SQLException
	{
		ArrayList<BoardVO> boarray = new ArrayList<BoardVO>();
		
		String sql2 = null;
		if("게시물 제목".equals(kindsofsearch1))
			sql2 = "select count(id) from board where title like ?";
		else if("작성자 이름".equals(kindsofsearch1))
			sql2 = "select count(id) from board where id like ?";
		pstmt = con.prepareStatement(sql2);
		String search3 = "%" + search1 + "%"; 
		pstmt.setString(1, search3);
		rs = pstmt.executeQuery();
		
		int num = 0;
		
		if(rs.next())
		{
			num = rs.getInt("count(id)");
		}
		int num2 = ((num-1)/10)+1;
		
		String sql = null;
		
		for(int i=1 ; i<=num2 ; i++)
		{
			if(page == i)
			{
				if("게시물 제목".equals(kindsofsearch1))
					sql = "select * from (select B.* , rownum as R from (select * from Board where title like ? order by board_id desc) B where rownum <= ?) where R >=?"; 
				else if("작성자 이름".equals(kindsofsearch1))
					sql = "select * from (select B.* , rownum as R from (select * from Board where id like ? order by board_id desc) B where rownum <= ?) where R >=?";
				
				pstmt = con.prepareStatement(sql);
				String search2 = "%" + search1 + "%";
				pstmt.setString(1, search2);
				
				if((((page-1)*10)+10) > num)
					pstmt.setInt(2, num);
				else
					pstmt.setInt(2, ((page-1)*10)+10);
				
				pstmt.setInt(3, ((page-1)*10)+1);
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					String id = rs.getString("id");
					int board_id = rs.getInt("board_id");
//					String id = rs.getString("id");
					String title = rs.getString("title");
					String text = rs.getString("text");
					Date d = rs.getDate("d");
					String filename = rs.getString("filename");
					//import util아님 sql임
					
					BoardVO tv = new BoardVO(id,board_id,title,text,d,filename);
					boarray.add(tv);
				}
			}
		}
		return boarray;
	}
	
	public ArrayList<BoardVO> searchinfo2(String kindsofsearch1 , String search1 , int page) throws SQLException
	{
		ArrayList<BoardVO> boarray = new ArrayList<BoardVO>();
		
		String sql2 = null;
		if("게시물 제목".equals(kindsofsearch1))
			sql2 = "select count(id) from board2 where title like ?";
		else if("작성자 이름".equals(kindsofsearch1))
			sql2 = "select count(id) from board2 where id like ?";
		pstmt = con.prepareStatement(sql2);
		String search3 = "%" + search1 + "%"; 
		pstmt.setString(1, search3);
		rs = pstmt.executeQuery();
		
		int num = 0;
		
		if(rs.next())
		{
			num = rs.getInt("count(id)");
		}
		int num2 = ((num-1)/10)+1;
		
		String sql = null;
		
		for(int i=1 ; i<=num2 ; i++)
		{
			if(page == i)
			{
				if("게시물 제목".equals(kindsofsearch1))
					sql = "select * from (select B.* , rownum as R from (select * from Board2 where title like ? order by board_id desc) B where rownum <= ?) where R >=?"; 
				else if("작성자 이름".equals(kindsofsearch1))
					sql = "select * from (select B.* , rownum as R from (select * from Board2 where id like ? order by board_id desc) B where rownum <= ?) where R >=?";
				
				pstmt = con.prepareStatement(sql);
				String search2 = "%" + search1 + "%";
				pstmt.setString(1, search2);
				
				if((((page-1)*10)+10) > num)
					pstmt.setInt(2, num);
				else
					pstmt.setInt(2, ((page-1)*10)+10);
				
				pstmt.setInt(3, ((page-1)*10)+1);
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					String id = rs.getString("id");
					int board_id = rs.getInt("board_id");
//					String id = rs.getString("id");
					String title = rs.getString("title");
					String text = rs.getString("text");
					Date d = rs.getDate("d");
					String filename = rs.getString("filename");
					//import util아님 sql임
					
					BoardVO tv = new BoardVO(id,board_id,title,text,d,filename);
					boarray.add(tv);
				}
			}
		}
		return boarray;
	}
	
	public ArrayList<BoardVO> searchinfo3(String kindsofsearch1 , String search1 , int page) throws SQLException
	{
		ArrayList<BoardVO> boarray = new ArrayList<BoardVO>();
		
		String sql2 = null;
		if("게시물 제목".equals(kindsofsearch1))
			sql2 = "select count(id) from board3 where title like ?";
		else if("작성자 이름".equals(kindsofsearch1))
			sql2 = "select count(id) from board3 where id like ?";
		pstmt = con.prepareStatement(sql2);
		String search3 = "%" + search1 + "%"; 
		pstmt.setString(1, search3);
		rs = pstmt.executeQuery();
		
		int num = 0;
		
		if(rs.next())
		{
			num = rs.getInt("count(id)");
		}
		int num2 = ((num-1)/10)+1;
		
		String sql = null;
		
		for(int i=1 ; i<=num2 ; i++)
		{
			if(page == i)
			{
				if("게시물 제목".equals(kindsofsearch1))
					sql = "select * from (select B.* , rownum as R from (select * from Board3 where title like ? order by board_id desc) B where rownum <= ?) where R >=?"; 
				else if("작성자 이름".equals(kindsofsearch1))
					sql = "select * from (select B.* , rownum as R from (select * from Board3 where id like ? order by board_id desc) B where rownum <= ?) where R >=?";
				
				pstmt = con.prepareStatement(sql);
				String search2 = "%" + search1 + "%";
				pstmt.setString(1, search2);
				
				if((((page-1)*10)+10) > num)
					pstmt.setInt(2, num);
				else
					pstmt.setInt(2, ((page-1)*10)+10);
				
				pstmt.setInt(3, ((page-1)*10)+1);
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					String id = rs.getString("id");
					int board_id = rs.getInt("board_id");
//					String id = rs.getString("id");
					String title = rs.getString("title");
					String text = rs.getString("text");
					Date d = rs.getDate("d");
					String filename = rs.getString("filename");
					//import util아님 sql임
					
					BoardVO tv = new BoardVO(id,board_id,title,text,d,filename);
					boarray.add(tv);
				}
			}
		}
		return boarray;
	}
	
	public ArrayList<BoardVO> searchMyPost1(String id , int page) throws SQLException
	{
		ArrayList<BoardVO> boarray = new ArrayList<BoardVO>();
		
		System.out.println("==========");
		String sql2 = null;
		sql2 = "select count(id) from board where id=?";
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		int num = 0;
		
		if(rs.next())
		{
			num = rs.getInt("count(id)");
		}
		int num2 = ((num-1)/10)+1;
		
		String sql = null;
		
		for(int i=1 ; i<=num2 ; i++)
		{
			if(page == i)
			{
				sql = "select * from (select B.* , rownum as R from (select * from board where id=? order by board_id desc) B where rownum <= ?) where R >=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				if((((page-1)*10)+10) > num)
					pstmt.setInt(2, num);
				else
					pstmt.setInt(2, ((page-1)*10)+10);
				
				pstmt.setInt(3, ((page-1)*10)+1);
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					String id2 = rs.getString("id");
					int board_id = rs.getInt("board_id");
//					String id = rs.getString("id");
					String title = rs.getString("title");
					String text = rs.getString("text");
					Date d = rs.getDate("d");
					String filename = rs.getString("filename");
					//import util아님 sql임
					
					BoardVO tv = new BoardVO(id2,board_id,title,text,d,filename);
					boarray.add(tv);
				}
			}
		}
		return boarray;
	}
	
	public ArrayList<BoardVO> searchMyPost2(String id , int page) throws SQLException
	{
		ArrayList<BoardVO> boarray = new ArrayList<BoardVO>();
		
		System.out.println("==========");
		String sql2 = null;
		sql2 = "select count(id) from board2 where id=?";
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		int num = 0;
		
		if(rs.next())
		{
			num = rs.getInt("count(id)");
		}
		int num2 = ((num-1)/10)+1;
		
		String sql = null;
		
		for(int i=1 ; i<=num2 ; i++)
		{
			if(page == i)
			{
				sql = "select * from (select B.* , rownum as R from (select * from board2 where id=? order by board_id desc) B where rownum <= ?) where R >=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				if((((page-1)*10)+10) > num)
					pstmt.setInt(2, num);
				else
					pstmt.setInt(2, ((page-1)*10)+10);
				
				pstmt.setInt(3, ((page-1)*10)+1);
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					String id2 = rs.getString("id");
					int board_id = rs.getInt("board_id");
//					String id = rs.getString("id");
					String title = rs.getString("title");
					String text = rs.getString("text");
					Date d = rs.getDate("d");
					String filename = rs.getString("filename");
					//import util아님 sql임
					
					BoardVO tv = new BoardVO(id2,board_id,title,text,d,filename);
					boarray.add(tv);
				}
			}
		}
		return boarray;
	}
	
	public ArrayList<BoardVO> searchMyPost3(String id , int page) throws SQLException
	{
		ArrayList<BoardVO> boarray = new ArrayList<BoardVO>();
		
		System.out.println("==========");
		String sql2 = null;
		sql2 = "select count(id) from board3 where id=?";
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		int num = 0;
		
		if(rs.next())
		{
			num = rs.getInt("count(id)");
		}
		int num2 = ((num-1)/10)+1;
		
		String sql = null;
		
		for(int i=1 ; i<=num2 ; i++)
		{
			if(page == i)
			{
				sql = "select * from (select B.* , rownum as R from (select * from board3 where id=? order by board_id desc) B where rownum <= ?) where R >=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				if((((page-1)*10)+10) > num)
					pstmt.setInt(2, num);
				else
					pstmt.setInt(2, ((page-1)*10)+10);
				
				pstmt.setInt(3, ((page-1)*10)+1);
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					String id2 = rs.getString("id");
					int board_id = rs.getInt("board_id");
//					String id = rs.getString("id");
					String title = rs.getString("title");
					String text = rs.getString("text");
					Date d = rs.getDate("d");
					String filename = rs.getString("filename");
					//import util아님 sql임
					
					BoardVO tv = new BoardVO(id2,board_id,title,text,d,filename);
					boarray.add(tv);
				}
			}
		}
		return boarray;
	}
	
	public boolean alldelete(String id1)
	   {
	      String sql = "delete from Board where id=?";
	   
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, id1);

	         pstmt.executeUpdate();
	      }
	      catch(SQLException e)
	      {
	         System.out.println("insert Exception");
	         return false;
	      }
	      
	      sql = "delete from Board2 where id=?";
	      
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, id1);

	         pstmt.executeUpdate();
	      }
	      catch(SQLException e)
	      {
	         System.out.println("insert Exception");
	         return false;
	      }
	      
	      sql = "delete from Board3 where id=?";
	      
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, id1);

	         pstmt.executeUpdate();
	      }
	      catch(SQLException e)
	      {
	         System.out.println("insert Exception");
	         return false;
	      }
	      
	      return true;
	   }
	
	public boolean delete(int board_id1)
	{
		String sql = "delete from Board where board_id=?";
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_id1);

			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("delete Exception");
			return false;
		}
		return true;
	}
	
	public boolean delete2(int board_id1)
	{
		String sql = "delete from Board2 where board_id=?";
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_id1);

			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("delete Exception");
			return false;
		}
		return true;
	}
	
	public boolean delete3(int board_id1)
	{
		String sql = "delete from Board3 where board_id=?";
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_id1);

			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("delete Exception");
			return false;
		}
		return true;
	}
	

//	
//	public boolean update_all(String name1 , String id1 , String pw , String pn1 , String dob1 , String sname) throws SQLException
//	{
//		String sql = "update member10 set name=? , id=? , pw=? , pn=? , dob=TO_DATE(?,'YYYY-MM-DD') where name=?";
//		
//		pstmt = con.prepareStatement(sql);
//		pstmt.setString(1,  name1);
//		pstmt.setString(2, id1);
//		pstmt.setString(3, pw);
//		pstmt.setString(4, pn1);
//		pstmt.setString(5, dob1);
//		pstmt.setString(6, sname);
//		
//		pstmt.executeUpdate();
//		
//		return true;
//	}
//	
//	public boolean update_nametel(String pn1,String name1)
//	{
//		String sql = "update member10 set pn = ? where name=?";
//		try {
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, pn1);
//			pstmt.setString(2, name1);
//			pstmt.executeUpdate();
//		}
//		catch(SQLException e)
//		{
//			System.out.println("update Exception");
//			return false;
//		}
//		return true;
//	}
//	
//	public boolean delete_nametel(String name1)
//	{
//		String sql = "delete from member10 where name=?";
//		try {
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, name1);
//			pstmt.executeUpdate();
//		}
//		catch(SQLException e)
//		{
//			System.out.println("delete Exception");
//			return false;
//		}
//		return true;
//	}
//	
//	/*자바의 sql의 Date처리는 다르다
//	- java.util.Date java.sql.Date
//	
//	1)to_date(?,'yyyy-MM-dd')
//	2)SimpleDateFormat
//		.parse .format
//	3)java , substring*/
//	

}
