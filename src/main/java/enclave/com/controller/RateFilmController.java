package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.entities.Rate;
import enclave.com.service.RateFilmService;

@RestController
@RequestMapping("/ratefilm")
public class RateFilmController {
	
	@Autowired
	RateFilmService rateFilmService ;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	ResponseEntity<Rate> addRate(@RequestBody Rate rate){
		if(rate!=null){
			rateFilmService.addRateFilm(rate);
			return new ResponseEntity<Rate>(rate,HttpStatus.OK);
		}
		return new ResponseEntity<Rate>(rate,HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<Rate>> getAllRate(){
		List<Rate> listRate = rateFilmService.getAllRate();
		if(listRate.isEmpty()) {
			ResponseEntity<List<Rate>> errorListRate = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorListRate;
		}
		return new ResponseEntity<>(listRate,HttpStatus.OK);
	}
}
