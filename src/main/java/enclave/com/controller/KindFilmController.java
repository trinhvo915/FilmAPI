package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.entities.*;
import enclave.com.service.KindFilmService;

@RestController
@RequestMapping("/kindfilm")
public class KindFilmController {
	
	@Autowired
	KindFilmService kindFilmService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<KindFilm>> getAllKindFilm(){
		List<KindFilm> listKindFilm= kindFilmService.kindfindAllFilm();
		if(listKindFilm.isEmpty()) {
			ResponseEntity<List<KindFilm>> errorListKindFilm = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorListKindFilm;
		}
		return new ResponseEntity<>(listKindFilm,HttpStatus.OK);
	}

}
