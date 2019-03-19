package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.dto.RateDTO;
import enclave.com.entities.Film;
import enclave.com.service.FilmService;
import enclave.com.service.RateFilmService;
import enclave.com.utils.ApiMessages;
import enclave.com.utils.LogicHandle;

@RestController
@RequestMapping("/film")
public class FilmController {
	
	@Autowired
	FilmService filmService;
		
	@Autowired
	RateFilmService rateFilmService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<Film>> getAllFilm(){
		List<Film> listFilm = filmService.findAllFilm();
		if(listFilm.isEmpty()) {
			ResponseEntity<List<Film>> errorListFilm = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorListFilm;
		}
		return new ResponseEntity<>(listFilm,HttpStatus.OK);
	}
	
	@RequestMapping(value="/search/{name}", method=RequestMethod.GET)
	public ResponseEntity<List<Film>> SearchAllFilm(@PathVariable("name")String name){
		System.out.println("name == "+name);
		List<Film> listFilm = filmService.searchFilmByName(name);
		if(listFilm.isEmpty()) {
			ResponseEntity<List<Film>> errorListFilm = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorListFilm;
		}
		return new ResponseEntity<>(listFilm,HttpStatus.OK);
	}
	
	@RequestMapping(value="/top",method= RequestMethod.GET)
	public ResponseEntity<List<Film>> getTopFilm(){
		List<Film> listfilmtop = filmService.getTopFilm12();
		if(listfilmtop.isEmpty()) {
			ResponseEntity<List<Film>> errorList = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorList;
		}
		return new  ResponseEntity<>(listfilmtop,HttpStatus.OK);
	}
	
	@RequestMapping(value="/page",method= RequestMethod.GET)
	public ResponseEntity<List<Film>> getPageFilm(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
		      @RequestParam(name = "size", required = false, defaultValue = "12") Integer size,
		      @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort){
		Sort sortable = null;
	    if (sort.equals("ASC")) {
	      sortable = Sort.by("id").ascending();
	    }
	    if (sort.equals("DESC")) {
	      sortable = Sort.by("id").descending();
	    }
	    Pageable pageable = PageRequest.of(page, size, sortable);
	    List<Film> listfilmpage = filmService.listPageFilm(pageable);
		
	    if(listfilmpage.isEmpty()) {
			ResponseEntity<List<Film>> errorList = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorList;
		}
		return new  ResponseEntity<>(listfilmpage,HttpStatus.OK);
	}
	@RequestMapping(value="/random",method= RequestMethod.GET)
	public ResponseEntity<List<Film>> getRamdomFilm(){
		List<Film> listFilm = filmService.findAllFilm();
		List<Film> listfilmramdom = LogicHandle.functionRandomFilm(listFilm);
		if(listfilmramdom.isEmpty()) {
			ResponseEntity<List<Film>> errorlistfilmramdom = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorlistfilmramdom;
		}
		return new  ResponseEntity<>(listfilmramdom,HttpStatus.OK);
	}
	@RequestMapping(value="/week",method= RequestMethod.GET)
	public ResponseEntity<List<Film>> getFilmWeeks(){
		List<Film> listfilmWeek = filmService.showListFilmWeek();
		if(listfilmWeek.isEmpty()) {
			ResponseEntity<List<Film>> errorlistfilmWeek = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorlistfilmWeek;
		}
		return new  ResponseEntity<>(listfilmWeek,HttpStatus.OK);
	}
	
	@RequestMapping(value="/month",method= RequestMethod.GET)
	public ResponseEntity<List<Film>> getFilmMonths(){
		List<Film> listfilmMonth = filmService.showListFilmMonth();
		if(listfilmMonth.isEmpty()) {
			ResponseEntity<List<Film>> errorlistfilmMonth = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return errorlistfilmMonth;
		}
		return new  ResponseEntity<>(listfilmMonth,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Film> addFilm (@RequestBody Film film){
		boolean checkFilm = filmService.addFilm(film);
		if(checkFilm){
			return new ResponseEntity<Film>(film,HttpStatus.OK);
		}
		String message = "Add Film not Success !!!";
		return new ResponseEntity(message,HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<Film> updateFilm (@RequestBody Film film){
		List<Film> listFilm = filmService.findAllFilm();
		boolean checkFilm = LogicHandle.functionCheckFilm(listFilm,film);
		if(checkFilm){
			filmService.updateFilm(film);
			return new ResponseEntity<Film>(film,HttpStatus.OK);
		}
		String message = "Update Film not Success !!!";
		return new ResponseEntity(message,HttpStatus.NOT_FOUND);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Film> deleteFilm (@PathVariable("id") Integer id){
		boolean checkDeleteFilm = filmService.deleteFilm(id);
		if(checkDeleteFilm){
			String messageS = "Delete Success";
			return new ResponseEntity(messageS,HttpStatus.OK);
		}
		String message = "Update Film not Success !!!";
		return new ResponseEntity(message,HttpStatus.NOT_FOUND);
	}
	

	//
	//Get average of a film
	//
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("score/{id_film}")
	public ResponseEntity<RateDTO> getScoreFilm(@PathVariable("id_film") long id_film){
		if (rateFilmService.scoreFilm(id_film) == null) {
			ApiMessages err = new ApiMessages("No one rate this film have id: " + id_film);
			return new ResponseEntity(err, HttpStatus.NO_CONTENT);
		} else {
			float score = rateFilmService.scoreFilm(id_film);
			RateDTO rateDTO = new RateDTO(score);
			return new ResponseEntity<RateDTO>(rateDTO, HttpStatus.OK);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public ResponseEntity<Film> setViewFilm(@PathVariable("id") Long id){
		Film film = filmService.setView(id);
		if(film!=null){
			String message = "Add view Success";
			return new ResponseEntity( message, HttpStatus.OK);
		}
		String message = "Add view no Success";
		return new ResponseEntity(message,HttpStatus.NOT_FOUND);	
	}
}
