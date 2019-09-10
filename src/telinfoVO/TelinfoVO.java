package telinfoVO;

import java.util.Date;

public class TelinfoVO {

	private String name;
	private String id;
	private String pw;
	private Date dob;
	private String jb1;
	private String jb2;
	private String pn1;
	private String pn2;
	private String pn3;
	
	public TelinfoVO(String name, String id, String pw, Date dob, String jb1, String jb2, String pn1, String pn2, String pn3) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.dob = dob;
		this.jb1 = jb1;
		this.jb2 = jb2;
		this.pn1 = pn1;
		this.pn2 = pn2;
		this.pn3 = pn3;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getJb1() {
		return jb1;
	}
	public void setJb1(String jb1) {
		this.jb1 = jb1;
	}
	public String getJb2() {
		return jb2;
	}
	public void setJb2(String jb2) {
		this.jb2 = jb2;
	}
	public String getPn1() {
		return pn1;
	}
	public void setPn1(String pn1) {
		this.pn1 = pn1;
	}
	public String getPn2() {
		return pn2;
	}
	public void setPn2(String pn2) {
		this.pn2 = pn2;
	}
	public String getPn3() {
		return pn3;
	}
	public void setPn3(String pn3) {
		this.pn3 = pn3;
	}
	
	
}
