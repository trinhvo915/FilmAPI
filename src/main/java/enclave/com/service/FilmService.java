package enclave.com.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import enclave.com.entities.Film;

public interface FilmService {
	List<Film> findAllFilm();
	/* v1 - 25/02/2019 */
	List<Film> getTopFilm12();
	
	List<Film> listPageFilm(Pageable  pageable);
	
	List<Film> showListFilmRandom();
	
	List<Film> showListFilmWeek();
	
	List<Film> showListFilmMonth();
	
	/* end*/
}
