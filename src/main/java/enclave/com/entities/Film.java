package enclave.com.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_film;
	@Column(name = "name_vn")
	private String name_vn;
	@Column(name = "name_en")
	private String name_en;
	@Column(name = "year")
	private Date year;
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
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "film_kindfilm",
			joinColumns =  @JoinColumn(name = "id_film"),
			inverseJoinColumns = @JoinColumn(name = "id_kind"))
	private Set<KindFilm> kindFilm = new HashSet<>();

	@OneToMany(mappedBy="film")
	private Set<Comment> listComment = new HashSet<>(); ;
	
	@OneToMany(mappedBy="film")
	private Set<Favourite> listFavourite = new HashSet<>();;
	
	public Film() {
		super();
	}

	public Film(long id_film, String name_vn, String name_en, Date year,
			int time, String actors, String description, String link_img_avt,
			String link_img_bg, String link_film, String link_trailer,
			int views_week, int views_month) {
		super();
		this.id_film = id_film;
		this.name_vn = name_vn;
		this.name_en = name_en;
		this.year = year;
		this.time = time;
		this.actors = actors;
		this.description = description;
		this.link_img_avt = link_img_avt;
		this.link_img_bg = link_img_bg;
		this.link_film = link_film;
		this.link_trailer = link_trailer;
		this.views_week = views_week;
		this.views_month = views_month;
	}

	public Film(long id_film, String name_vn, String name_en, Date year,
			int time, String actors, String description, String link_img_avt,
			String link_img_bg, String link_film, String link_trailer,
			int views_week, int views_month, Set<KindFilm> kindFilm) {
		super();
		this.id_film = id_film;
		this.name_vn = name_vn;
		this.name_en = name_en;
		this.year = year;
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

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
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

 /*
	public Set<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(Set<Comment> listComment) {
		this.listComment = listComment;
	}

	public Set<Favourite> getListFavourite() {
		return listFavourite;
	}

	public void setListFavourite(Set<Favourite> listFavourite) {
		this.listFavourite = listFavourite;
	}
*/
	
}