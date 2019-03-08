package enclave.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enclave.com.entities.Film;
import enclave.com.repository.FilmRepository;
import enclave.com.service.FavouriteService;


@Service
public class FavouriteServiceImpl implements FavouriteService{

	@Autowired
	FilmRepository filmRepository;

	@Override
	public List<Film> getListFilmFavourite(Integer id) {
		return filmRepository.getListFilmFavourite(id);
	}
	

}
