package enclave.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import enclave.com.entities.Favourite;
import enclave.com.entities.Film;

public interface FavouriteService {
	// id is id of User <=> id = idUser
	// get all film that user was liked
	List<Film> getListFilmFavourite(Integer id);
	
	boolean addFavourite(Favourite favourite);
	
	//Get list film favourited user pageable
	List<Film> getListFilmFavouritePageable(Integer id, Pageable pageable);
	
	// id = idFavourite
	Favourite getFavouriteById(Integer id);
	
	Film checkFavouriteFilm(Integer id_user, Integer id_film);
	
	boolean deleteFavourite(Integer id_uer, Integer id_film);

}
