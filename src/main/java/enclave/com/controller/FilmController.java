package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.entities.Film;
import enclave.com.service.FilmService;
import enclave.com.utils.LogicHandle;

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
	

}
