package telinfoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import telinfoDBConn.TelinfoDBConn;
import telinfoVO.TelinfoVO;

public class TelinfoDAO {

	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public TelinfoDAO() throws ClassNotFoundException, SQLException {
		con = new TelinfoDBConn().getConnection();
	}
	
	public void PstmtClose() throws SQLException {
		if(pstmt != null) pstmt.close();
	}
	
	public void getAllInfoClose() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}

	
//	public ArrayList<TelinfoVO> getAllInfo() throws SQLException{
//		ArrayList<TelinfoVO> tiarray =  new ArrayList<TelinfoVO>();
//		String sql = "SELECT * FROM TelTable5 ORDER BY id";
//		
//		pstmt = con.prepareStatement(sql);
//		rs = pstmt.executeQuery();
//		while(rs.next()) {
//			int id = rs.getInt("id");
//			String name = rs.getString("name");
//			String tel = rs.getString("tel");
//			Date d = rs.getDate("d");
//			/*
//			TelinfoVO tv = new TelinfoVO(id,name,tel,d);
//			tiarray.add(tv);*/
//		}
//		return tiarray;
//	}
	
	public TelinfoVO getInfo(String id1) throws SQLException {
		TelinfoVO tv = null;
		String sql = "SELECT * FROM Member where id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id1);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			String name = rs.getString("name");
			String id= rs.getString("id");
			String pw=rs.getString("pw");
			Date dob = rs.getDate("dob");
			String jb1 = rs.getString("jb1");
			String jb2 = rs.getString("jb2");
			String pn1 = rs.getString("pn1");
			String pn2 = rs.getString("pn2");
			String pn3 = rs.getString("pn3");
			
			tv = new TelinfoVO(name,id,pw,dob,jb1,jb2,pn1,pn2,pn3);		
			
		}else {
			tv = null; 
		}
		return tv; 
	}
	
//	public boolean update_all(int id1, String name1, String tel1, String d, String sname) throws SQLException {
//		String sql = "update TelTable5 set id=?, name=?, tel=?, d = TO_DATE(?,'YYYY-MM-DD') where name?";
//		
//		pstmt = con.prepareStatement(sql);
//		pstmt.setInt(1, id1);
//		pstmt.setString(2, name1);
//		pstmt.setString(3, tel1);
//		pstmt.setString(4, d);
//		pstmt.setString(5, sname);
//		
//		pstmt.executeUpdate();
//		
//		return true;
//	}
	
	public boolean update_passward(String pw,String id) {
		String sql = "update Member set pw=? where id=?";
		try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pw);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("update Exception");
			return false;
		}
		return true;
	}
	
	public boolean terminate(String id1) {
		String sql = "delete from member where id=?";
		try 
		{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id1);
				
				pstmt.executeUpdate();
		}
		catch(SQLException e) 
		{
			System.out.println("delete Exception");
			return false;
		}
		return true;
	}
	
	public boolean Insert(String name, String id, String pw, Date dob, String jb1, String jb2, String pn1, String pn2, String pn3) { 
		String sql = "insert into Member values(?,?,?,?,?,?,?,?,?)";  //
		

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setDate(4, dob);
			pstmt.setString(5, jb1);
			pstmt.setString(6, jb2);
			pstmt.setString(7, pn1);
			pstmt.setString(8, pn2);
			pstmt.setString(9, pn3);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Insert Exception");
			return false;
		}
		return true;
	}
	
	public boolean Login (String id, String pw) { 
		String sql = "select pw from Member where id=?";  //
		String pw1 = null;

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				pw1 = rs.getString("pw");
			}
			
			if(pw1 == null)
				return false;
			
			if(pw1.equals(pw))
			{
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("update Exception");
			
		}
		return false;
	}
	
	public boolean memberChk (String name, String jb1, String jb2) { 
		String sql = "select name from Member where jb1=? and jb2=?";
		String name1 = null;

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, jb1);
			pstmt.setString(2, jb2);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				name1 = rs.getString("name");
			}

			if(name1 == null)
				return true;
			
		} catch (SQLException e) {
			System.out.println("update Exception");
			
		}
		return false;
	}
	
	public String id_Find(String name, String jb1, String jb2) { 
		String sql = "select id from Member where name=? and jb1=? and jb2=?";
		String id1 = null;

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, jb1);
			pstmt.setString(3, jb2);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				id1 = rs.getString("id");
			}
			else
			{
				id1 = "";
			}

		} catch (SQLException e) {
			System.out.println("update Exception");
			
		}
		return id1;
	}
	
	public String pw_Find(String id, String name, String jb1, String jb2) { 
		String sql = "select pw from Member where id=? and name=? and jb1=? and jb2=?";
		String pw1 = null;

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, jb1);
			pstmt.setString(4, jb2);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				pw1 = rs.getString("pw");
			}
			else
			{
				pw1 = "";
			}
			
		} catch (SQLException e) {
			System.out.println("update Exception");
			
		}
		return pw1;
	}
	
	public boolean idChk (String id) { 
		String sql = "select id from Member where id=?";
		String id1 = null;
		
		try 
		{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				id1 = rs.getString("id");
			}
			
			if(id1 == null)
				return true;
			
		} catch (SQLException e) {
			System.out.println("idChk Exception");
			
		}
		return false;
	}
	
	public boolean pwChk (String id , String pw) 
	{ 
		String sql = "select pw from Member where id=? and pw=?";
		String pw1 = null;
		
		try 
		{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				pw1 = rs.getString("pw");
			}
			
			if(pw1 == null)
				return false;
			
		} catch (SQLException e) {
			System.out.println("idChk Exception");
			
		}
		return true;
	}
}
