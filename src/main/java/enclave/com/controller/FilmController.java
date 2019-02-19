package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.entities.Film;
import enclave.com.service.FilmService;

@RestController
@RequestMapping("/film")
public class FilmController {
	
	@Autowired
	FilmService filmService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<Film>> getAllFilm(){
		List<Film> listFilm = filmService.findAllFilm();
		if(listFilm.isEmpty()) {
			ResponseEntity<List<Film>> errorListFilm = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorListFilm;
		}
		return new ResponseEntity<>(listFilm,HttpStatus.OK);
	}
	
	

}
