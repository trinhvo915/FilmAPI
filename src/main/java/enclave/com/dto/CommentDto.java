package enclave.com.dto;

import enclave.com.entities.*;

public class CommentDto {

	private Integer id_cmt;

	private String content;
	
	private User user;
	
	private Film film;

	public CommentDto() {
		super();
	}

	public CommentDto(Integer id_cmt, String content, User user) {
		super();
		this.id_cmt = id_cmt;
		this.content = content;
		this.user = user;
	}
	

	public CommentDto(Integer id_cmt, String content, Integer id_user, Integer id_film) {
		super();
		this.id_cmt = id_cmt;
		this.content = content;
		this.user.setId_user(id_user);
		this.film.setId_film(id_film);
	}
	
	

	public CommentDto(Integer id_cmt, String content, User user, Film film) {
		super();
		this.id_cmt = id_cmt;
		this.content = content;
		this.user = user;
		this.film = film;
	}

	public Integer getId_cmt() {
		return id_cmt;
	}

	public void setId_cmt(Integer id_cmt) {
		this.id_cmt = id_cmt;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
