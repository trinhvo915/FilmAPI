package enclave.com.dto;

import java.sql.Date;

public class FilmDto {
	
	private long id_film;
	 
	private String name_vn;
 
	private String name_en;
 
	private Date year;
 
	private int time;
 
	private String actors;
 
	private String description;
 
	private String link_img_avt;
 
	private String link_img_bg;
 
	private String link_film;
 
	private String link_trailer;
 
	private int views_week;
 
	private int views_month;

 

	public FilmDto() {
		super();
	}

	public FilmDto(long id_film, String name_vn, String name_en, Date year, int time, String actors,
			String description, String link_img_avt, String link_img_bg, String link_film, String link_trailer,
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

	
}
