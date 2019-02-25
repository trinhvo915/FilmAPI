package enclave.com.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "kind_film")
public class KindFilm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_kind;
	
	@Column (name = "name_kind")
	private String name_kind;
	
	@ManyToMany(mappedBy = "kindFilm")
	@JsonBackReference
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

	public String getName_kind() {
		return name_kind;
	}

	public void setName_kind(String name_kind) {
		this.name_kind = name_kind;
	}

	public KindFilm(long id_kind,String name_kind, Collection<Film> films) {
		super();
		this.id_kind = id_kind;
		this.name_kind = name_kind;
		this.films = films;
	}

	public KindFilm() {
		super();
	}


}