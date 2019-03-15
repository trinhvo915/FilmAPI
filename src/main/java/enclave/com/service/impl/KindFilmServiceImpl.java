package enclave.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enclave.com.entities.*;
import enclave.com.repository.KindFilmRepository;
import enclave.com.service.KindFilmService;

@Service
public class KindFilmServiceImpl implements KindFilmService{
	
	@Autowired
	KindFilmRepository kindFilmRepository;


	@Override
	public List<KindFilm> kindfindAllFilm() {
		return (List<KindFilm>) kindFilmRepository.findAll();
	}

}
