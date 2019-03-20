package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.dto.RateDTO;
import enclave.com.entities.Rate;
import enclave.com.service.RateFilmService;

@RestController
@RequestMapping("/ratefilm")
public class RateFilmController {
	
	@Autowired
	RateFilmService rateFilmService ;

	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<Rate>> getAllRate(){
		List<Rate> listRate = rateFilmService.getAllRate();
		if(listRate.isEmpty()) {
			ResponseEntity<List<Rate>> errorListRate = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorListRate;
		}
		return new ResponseEntity<>(listRate,HttpStatus.OK);
	}
	
	//
	//Get score user rated film
	//
	@GetMapping("film/{id_film}/user/{id_user}")
	public ResponseEntity<RateDTO> getScore(@PathVariable("id_film") long id_film, @PathVariable("id_user") long id_user){
		//If user not yet rated film
		if (rateFilmService.getScore(id_film, id_user) == null) {
			RateDTO rateDTO = new RateDTO(0);
			return new ResponseEntity<RateDTO>(rateDTO,HttpStatus.OK);
		} else {
			int score = rateFilmService.getScore(id_film, id_user);
			RateDTO rateDTO = new RateDTO(score);
			return new ResponseEntity<RateDTO>(rateDTO,HttpStatus.OK);
		}
	}
	
	//
	//Add score rate film
	//
	@PostMapping("add")
	public ResponseEntity<RateDTO> addScore(@RequestBody Rate rate){
		System.out.println(rate.getFilm().getId_film() + rate.getScore() + rate.getUser().getId_user());
		//If user not yet rate film then add new score
		if (rateFilmService.getScore(rate.getFilm().getId_film(),rate.getUser().getId_user()) == 0) {
			rateFilmService.addRateFilm(rate);
			RateDTO rateDTO = new RateDTO(rate.getScore());
			return new ResponseEntity<RateDTO>(rateDTO, HttpStatus.OK);
		} else {
			//Update score
			rateFilmService.updateScore(rate.getFilm().getId_film(), rate.getUser().getId_user(), rate.getScore());
			
			RateDTO rateDTO = new RateDTO(rate.getScore());
			return new ResponseEntity<RateDTO>(rateDTO, HttpStatus.OK);
		}
		
	}
	
}
