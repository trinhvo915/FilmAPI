package enclave.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
	@Query(value = "SELECT f.id_film, f.name_vn, f.name_en, f.actors FROM film AS f",
			nativeQuery = true)
	List<Film> listLimitInforFilm();
	
}
