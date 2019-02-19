package enclave.com.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "kind_film")
public class KindFilm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_kind;

	@ManyToMany(mappedBy = "kindFilm")
	private Collection<Film> films;

	public long getId_kind() {
		return id_kind;
	}

	public void setId_kind(long id_kind) {
		this.id_kind = id_kind;
	}

	public Collection<Film> getFilms() {
		return films;
	}

	public void setFilms(Collection<Film> films) {
		this.films = films;
	}

	public KindFilm(long id_kind, Collection<Film> films) {
		super();
		this.id_kind = id_kind;
		this.films = films;
	}

	public KindFilm() {
		super();
	}


}