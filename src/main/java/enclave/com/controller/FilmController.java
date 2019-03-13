package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.dto.RateDTO;
import enclave.com.entities.Film;
import enclave.com.service.FilmService;
import enclave.com.service.RateService;
import enclave.com.utils.ApiMessages;

@RestController
@RequestMapping("film")
public class FilmController {
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private RateService rateService;
	
	@GetMapping("all")
	public ResponseEntity<List<Film>> getAll(){
		List<Film> listFilm = filmService.getAllFilm();
		return new ResponseEntity<List<Film>>(listFilm, HttpStatus.OK);
	}
	
	@GetMapping("limit/all")
	public ResponseEntity<List<Film>> getLimitFilm(){
		List<Film> listLimitFilm = filmService.listLimitInforFilm();
		return new ResponseEntity<List<Film>>(listLimitFilm, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("{id_film}")
	public ResponseEntity<Film> getFilm(@PathVariable("id_film") long id_film){
		if (filmService.getFilm(id_film) == null) {
			ApiMessages err = new ApiMessages("Can not found this id_film " + id_film);
			return new ResponseEntity(err, HttpStatus.NOT_FOUND);
		} else {
			Film film = filmService.getFilm(id_film);
			return new ResponseEntity<Film>(film, HttpStatus.OK);
		}
	}
	
	
	//
	//Get average of a film
	//
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("score-{id_film}")
	public ResponseEntity<RateDTO> getScoreFilm(@PathVariable("id_film") long id_film){
		if (rateService.scoreFilm(id_film) == null) {
			ApiMessages err = new ApiMessages("No one rate this film have id: " + id_film);
			return new ResponseEntity(err, HttpStatus.NO_CONTENT);
		} else {
			float score = rateService.scoreFilm(id_film);
			RateDTO rateDTO = new RateDTO(score);
			return new ResponseEntity<RateDTO>(rateDTO, HttpStatus.OK);
		}
	}
	
}
