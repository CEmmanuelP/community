package boardVO;

import java.util.Date;

public class BoardVO {
	private String id;
	private int board_id;
	private String title;
	private String text;
	private Date d;
	private String filename;
	
	public BoardVO(String id, int board_id, String title, String text, Date d,String filename) 
	{
		super();
		this.id = id;
		this.board_id = board_id;
		this.title = title;
		this.text = text;
		this.d = d;
		this.filename = filename;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
}
