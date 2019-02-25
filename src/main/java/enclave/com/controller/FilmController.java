package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
//	//@RequestMapping(value="/top10",method= RequestMethod.GET)
//	@RequestMapping(value = "/top10/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Film>> getTopFilm(@PathVariable("name") String name){
//		List<Film> listfilmtop = filmService.getTopFilm(name);
//		if(listfilmtop.isEmpty()) {
//			ResponseEntity<List<Film>> errorList = new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			return errorList;
//		}
//		return new  ResponseEntity<>(listfilmtop,HttpStatus.OK);
//		
//	}
//	
	

}
