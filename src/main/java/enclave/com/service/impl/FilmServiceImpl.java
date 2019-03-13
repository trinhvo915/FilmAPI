package enclave.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enclave.com.entities.Film;
import enclave.com.repository.FilmRepository;
import enclave.com.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmRepository filmRepository;
	
	@Override
	public List<Film> listLimitInforFilm(){
		List<Film> listFilm = filmRepository.listLimitInforFilm();
		return listFilm;
	}
	
	@Override
	public List<Film> getAllFilm() {
		List<Film> listFilm = filmRepository.findAll();
		
		return listFilm;
	}

	@Override
	public Film getFilm(long id_film) {
		Optional<Film> objFilm = filmRepository.findById(id_film);
		return objFilm.get();
	}

	@Override
	public Film addFilm(Film film) {
		
		return filmRepository.save(film);
	}

	@Override
	public Film updateFilm(Film film) {
		return filmRepository.save(film);
	}

	@Override
	public boolean deleteFilm(long id_film) {
		Film objFilm = filmRepository.getOne(id_film);
		if (objFilm != null) {
			filmRepository.delete(objFilm);
			return true;
		} else {
			return false;
		}
		
	}

}
