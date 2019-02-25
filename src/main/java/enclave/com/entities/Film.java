package enclave.com.entities;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "film")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_film;
	@Column(name = "name_vn")
	private String name_vn;
	@Column(name = "name_en")
	private String name_en;
	@Column(name = "date_create")
	private Timestamp date_create;
	@Column (name = "time")
	private int time;
	@Column (name = "actors")
	private String actors;
	@Column(name = "description")
	private String description;
	@Column(name = "link_img_avt")
	private String link_img_avt;
	@Column(name = "link_img_bg")
	private String link_img_bg;
	@Column(name = "link_film")
	private String link_film;
	@Column(name = "link_trailer")
	private String link_trailer;
	@Column(name = "views_week")
	private int views_week;
	@Column(name = "views_month")
	private int views_month;

	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
                })
	@JoinTable(name = "film_kindfilm",
			joinColumns =  @JoinColumn(name = "id_film"),
			inverseJoinColumns = @JoinColumn(name = "id_kind"))
	
	@JsonManagedReference
	private Set<KindFilm> kindFilm;

	public long getId_film() {
		return id_film;
	}

	public void setId_film(long id_film) {
		this.id_film = id_film;
	}

	public String getName_vn() {
		return name_vn;
	}

	public void setName_vn(String name_vn) {
		this.name_vn = name_vn;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public Timestamp getDate_create() {
		return date_create;
	}

	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink_img_avt() {
		return link_img_avt;
	}

	public void setLink_img_avt(String link_img_avt) {
		this.link_img_avt = link_img_avt;
	}

	public String getLink_img_bg() {
		return link_img_bg;
	}

	public void setLink_img_bg(String link_img_bg) {
		this.link_img_bg = link_img_bg;
	}

	public String getLink_film() {
		return link_film;
	}

	public void setLink_film(String link_film) {
		this.link_film = link_film;
	}

	public String getLink_trailer() {
		return link_trailer;
	}

	public void setLink_trailer(String link_trailer) {
		this.link_trailer = link_trailer;
	}

	public int getViews_week() {
		return views_week;
	}

	public void setViews_week(int views_week) {
		this.views_week = views_week;
	}

	public int getViews_month() {
		return views_month;
	}

	public void setViews_month(int views_month) {
		this.views_month = views_month;
	}

	public Set<KindFilm> getKindFilm() {
		return kindFilm;
	}

	public void setKindFilm(Set<KindFilm> kindFilm) {
		this.kindFilm = kindFilm;
	}

	public Film(long id_film, String name_vn, String name_en, Timestamp date_create, int time, String actors,
			String description, String link_img_avt, String link_img_bg, String link_film, String link_trailer,
			int views_week, int views_month, Set<KindFilm> kindFilm) {
		super();
		this.id_film = id_film;
		this.name_vn = name_vn;
		this.name_en = name_en;
		this.date_create = date_create;
		this.time = time;
		this.actors = actors;
		this.description = description;
		this.link_img_avt = link_img_avt;
		this.link_img_bg = link_img_bg;
		this.link_film = link_film;
		this.link_trailer = link_trailer;
		this.views_week = views_week;
		this.views_month = views_month;
		this.kindFilm = kindFilm;
	}

	public Film(long id_film, String name_vn, String name_en, Timestamp date_create, Set<KindFilm> kindFilm) {
		super();
		this.id_film = id_film;
		this.name_vn = name_vn;
		this.name_en = name_en;
		this.date_create = date_create;
		this.kindFilm = kindFilm;
	}

	public Film() {
		super();
	}



}