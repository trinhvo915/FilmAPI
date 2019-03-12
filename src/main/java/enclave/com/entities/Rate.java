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
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id_rate;
	
	@Column(name="score")
	private Integer score;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_film")
	private Film film;

	public Rate() {
		super();
	}

	public Rate(Long id_rate, Integer score, User user, Film film) {
		super();
		this.id_rate = id_rate;
		this.score = score;
		this.user = user;
		this.film = film;
	}

	public Long getId_rate() {
		return id_rate;
	}

	public void setId_rate(Long id_rate) {
		this.id_rate = id_rate;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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
