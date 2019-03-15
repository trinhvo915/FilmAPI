package enclave.com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favourite")
public class Favourite implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_favourite;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name ="id_film")
	private Film film;

	public Favourite() {
		super();
	}

	public Favourite(long id_favourite) {
		super();
		this.id_favourite = id_favourite;
	}

	public Favourite(long id_favourite, User user, Film film) {
		this.id_favourite = id_favourite;
		this.user = user;
		this.film = film;
	}

	public long getId_favourite() {
		return id_favourite;
	}

	public void setId_favourite(long id_favourite) {
		this.id_favourite = id_favourite;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
}
