package enclave.com.service;

import java.util.List;

import enclave.com.entities.Rate;

public interface RateFilmService {
	
	List<Rate> getAllRate();
	boolean addRateFilm(Rate rate);

}
