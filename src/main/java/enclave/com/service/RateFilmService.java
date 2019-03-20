package enclave.com.service;

import java.util.List;

import enclave.com.entities.Rate;

public interface RateFilmService {
	
	List<Rate> getAllRate();
	boolean addRateFilm(Rate rate);
	
	//List score of film via id_film
	Float scoreFilm(long id_film);

	//Get score user rate film
	Integer getScore(long id_film, long id_user);
	
	//Update Rate
	void updateScore(long id_film, long id_user, float score);
	
}
