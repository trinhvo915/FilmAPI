package enclave.com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue
	@Column(name = "id_cmt")
	private long id_cmt;
	
	@ManyToOne
	@JoinColumn (name = "id_film")
	private Film film;
	
	@ManyToOne
	@JoinColumn (name = "id_user")
	private User user;
	
	@Column(name = "content")
	private String content;
	

	public long getId_cmt() {
		return id_cmt;
	}

	public void setId_cmt(long id_cmt) {
		this.id_cmt = id_cmt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Film getFilm() {
		return film;
	}
	
	public void setFilm(Film film) {
		this.film = film;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment(String content, Film film, User user) {
		super();
		this.content = content;
		this.film = film;
		this.user = user;
	}
	
	public Comment(Comment cmt) {
		super();
		this.content = cmt.getContent();
		this.film = cmt.getFilm();
		this.user = cmt.getUser();
	}
	

	public Comment() {
		super();
	}
	
	
}
