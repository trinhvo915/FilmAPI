package enclave.com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rate_film")
public class Rate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_rate;
	
	@ManyToOne
	@JoinColumn(name = "id_film")
	private Film film;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Column(name = "score")
	private float score;

	public long getId_rate() {
		return id_rate;
	}

	public void setId_rate(long id_rate) {
		this.id_rate = id_rate;
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

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Rate(Film film, User user, float score) {
		super();
		this.film = film;
		this.user = user;
		this.score = score;
	}
	
	public Rate(Rate rate) {
		this.film = rate.getFilm();
		this.user = rate.getUser();
		this.score = rate.getScore();
	}
	
	public Rate(long id_rate, Film film, float score) {
		this.id_rate = id_rate;
		this.film = film;
		this.score = score;
	}
	
}
