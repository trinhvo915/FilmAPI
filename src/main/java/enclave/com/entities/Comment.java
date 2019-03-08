package enclave.com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="comment")
public class Comment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cmt;
	
	@Column(name ="content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="id_film")
	private Film film;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Comment() {
		super();
	}


	public Comment(String content, Film film, User user) {
		super();
		this.content = content;
		this.film = film;
		this.user = user;
	}
	public Integer getId_cmt() {
		return id_cmt;
	}

	public void setId_cmt(Integer id_cmt) {
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

	@Override
	public String toString() {
		return "Comment [id_cmt=" + id_cmt + ", content=" + content + ", film="
				+ film + ", user=" + user + "]";
	}

}
