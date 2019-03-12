package enclave.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import enclave.com.entities.Film;
import enclave.com.repository.FilmRepository;
import enclave.com.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	FilmRepository filmRepository;

	@Override
	public List<Film> findAllFilm() {
		return (List<Film>)filmRepository.findAll();
	}

	@Override
	public List<Film> getTopFilm12() {
		return (List<Film>)filmRepository.getFilmLimit12();
	}

	@Override
	public List<Film> listPageFilm(Pageable pageable) {
		return (List<Film>)filmRepository.getFilmPage(pageable);
	}

	@Override
	public List<Film> showListFilmRandom() {
		return (List<Film>)filmRepository.getRandomFilm();
	}

	@Override
	public List<Film> showListFilmWeek() {
		return (List<Film>)filmRepository.getFilmWeek();
	}

	@Override
	public List<Film> showListFilmMonth() {
		return (List<Film>)filmRepository.getFilmMonth();
	}
	
	@Override
	public List<Film> getFilmIdFilm(Integer id) {
		return (List<Film>)filmRepository.getFilmIdFilm(id);
	}

	@Override
	public boolean addFilm(Film film) {
		Film filmInDB = filmRepository.save(film);
		if(filmInDB != null){
			filmRepository.save(film);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteFilm(Integer id) {
		Film film = filmRepository.getOne(Long.parseLong(id+""));
		if(film !=null){
			filmRepository.delete(film);
			return true;
		}
		return false;
	}

	@Override
	public Film updateFilm(Film film) {
		// check film have exited in Class FilmController
		return filmRepository.save(film);
	}
	

	
	
	
	
	

}
