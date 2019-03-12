package enclave.com.service.impl;

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
	
}
