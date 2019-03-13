package enclave.com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enclave.com.repository.RateRepository;
import enclave.com.service.RateService;

@Service
public class RateServiceImpl implements RateService {
	@Autowired
	private RateRepository rateRepository;

	@Override
	public Float scoreFilm(long id_film) {
		
		ArrayList<Integer> listScore = rateRepository.listScore(id_film);
		float score = 0;
		for (int item: listScore) {
			score += item;
		}
		return score/listScore.size();
	}



}
