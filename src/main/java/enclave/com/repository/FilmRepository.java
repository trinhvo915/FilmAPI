package enclave.com.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import enclave.com.entities.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
	
	@Query(value="SELECT * FROM film  ORDER BY id_film ASC Limit 0, 12	", nativeQuery=true)
	List<Film> getFilmLimit12();
	
	@Query("SELECT e FROM Film e")
	List<Film> getFilmPage(Pageable pageable);
	
	@Query(value ="Select * from film f where f.id_film = :id", nativeQuery=true)
	List<Film> getFilmIdFilm(@Param("id") Integer id);
	
	/* the function getRandomFilm() is not use in project */
	@Query(nativeQuery=true, value="SELECT * FROM film RAND LIMIT 5")
	List<Film> getRandomFilm();
	
	@Query(value="SELECT * FROM film ORDER BY views_week DESC Limit 0, 12 ", nativeQuery=true)
	List<Film> getFilmWeek();
	
	@Query(value="SELECT * FROM film ORDER BY views_month DESC Limit 0, 12 ", nativeQuery=true)
	List<Film> getFilmMonth();
	
	@Query(nativeQuery=true,value="SELECT film.id_film,film.name_vn,film.name_en,film.year,film.time,film.actors,film.description,film.link_img_avt,film.link_img_bg,film.link_film,film.link_trailer,film.views_week,film.views_month FROM film LEFT JOIN favourite ON film.id_film = favourite.id_film LEFT JOIN users ON favourite.id_user = users.id_user WHERE favourite.id_user = :id")
	List<Film> getListFilmFavourite(@Param("id") Integer id);
		
	@Query(nativeQuery=true,value="SELECT * FROM film WHERE name_vn LIKE CONCAT('%',:name,'%') OR name_en LIKE CONCAT('%',:name,'%')")
	List<Film> getListFilmNameFilm(@Param("name") String name);
	// id =  id film
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true,value="UPDATE film SET views_week = views_week + 1, views_month = views_month + 1 WHERE id_film = :id")
	Integer setView(@Param("id") Long id);
	
}
