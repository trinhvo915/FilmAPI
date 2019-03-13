package enclave.com.dto;

public class CommentDTO {
	private long id_cmt;
	private String name_en;
	private String username;
	private String content;
	public long getId_cmt() {
		return id_cmt;
	}
	public void setId_cmt(long id_cmt) {
		this.id_cmt = id_cmt;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CommentDTO(long id_cmt, String name_en, String username, String content) {
		super();
		this.id_cmt = id_cmt;
		this.name_en = name_en;
		this.username = username;
		this.content = content;
	}
	public CommentDTO() {
		super();
	}
	
	
}
