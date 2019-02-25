package enclave.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Film> getTopFilm(String chars) {
		return null;//(List<Film>)filmRepository.findByNameEndsWith(name);
	}
	
	
	
	

}
