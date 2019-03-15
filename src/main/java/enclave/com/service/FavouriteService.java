package enclave.com.service;

import java.util.List;

import enclave.com.entities.Favourite;
import enclave.com.entities.Film;

public interface FavouriteService {
	// id is id of User <=> id = idUser
	// get all film that user was liked
	List<Film> getListFilmFavourite(Integer id);
	
	boolean addFavourite(Favourite favourite);
	
	boolean deleteFavourite(Integer id);
	
	// id = idFavourite
	Favourite getFavouriteById(Integer id);
	
	

}
