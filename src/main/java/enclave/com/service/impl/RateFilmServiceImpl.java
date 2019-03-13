package enclave.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enclave.com.entities.Rate;
import enclave.com.repository.RateFilmRepository;
import enclave.com.service.RateFilmService;


@Service
public class RateFilmServiceImpl implements RateFilmService{

	@Autowired
	RateFilmRepository rateFilmRepository ;
	
	@Override
	public boolean addRateFilm(Rate rate) {
		Rate rateadd = rateFilmRepository.save(rate);
		if(rateadd !=null){
			return true;
		}
		return false;
	}

	@Override
	public List<Rate> getAllRate() {
		return rateFilmRepository.findAll();
	}
	
	
	@Override
	public Float scoreFilm(long id_film) {
		
		ArrayList<Integer> listScore = rateFilmRepository.listScore(id_film);
		float score = 0;
		for (int item: listScore) {
			score += item;
		}
		return score/listScore.size();
	}

}
