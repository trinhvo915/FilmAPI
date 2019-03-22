package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.entities.Favourite;
import enclave.com.entities.Film;
import enclave.com.service.impl.FavouriteServiceImpl;
import enclave.com.utils.ApiMessages;

@RestController
@RequestMapping("/favourite")
public class FavouriteController {
	
	@Autowired
	FavouriteServiceImpl favouriteServiceImpl;
	
	@RequestMapping(value="/idFilm")
	public ResponseEntity<List<Film>> getListFavouriteFilm(@RequestParam(name="idUser", required = false) Integer id){
		System.out.println("this is "+id);
		List<Film> listFilm = favouriteServiceImpl.getListFilmFavourite(id);
		if(listFilm.size()==0){
			return new ResponseEntity<List<Film>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Film>>(listFilm,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/addFavourite",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Favourite> addFavourite(@RequestBody Favourite favourite){
		if(favourite != null){
			favouriteServiceImpl.addFavourite(favourite);
			return new ResponseEntity<Favourite>(favourite,HttpStatus.OK);
		}
		return new ResponseEntity<Favourite>(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value ="/delete/{id}",method=RequestMethod.DELETE)
	ResponseEntity<Favourite> deleteFavourite(@PathVariable("id") Integer id){
		Favourite favourite = favouriteServiceImpl.getFavouriteById(id);
		if(favourite!=null){
			boolean checkDelete = favouriteServiceImpl.deleteFavourite(id);
			if(checkDelete){
				String messageS = "Delete Success";
				return new ResponseEntity(messageS,HttpStatus.OK);
			}
		}
		String messageU = "Delete Not Success";
		return new ResponseEntity(messageU,HttpStatus.NOT_FOUND);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/checkfavourite/{id_user}/{id_film}",method=RequestMethod.GET)
	public ResponseEntity<Film> checkFavouriteFilm(@PathVariable("id_user") Integer id_user,@PathVariable("id_film") Integer id_film){
		Film film = favouriteServiceImpl.checkFavouriteFilm(id_user, id_film);
		if(film !=null){
			ApiMessages msg = new ApiMessages("true");
			return new ResponseEntity(msg,HttpStatus.OK);
		}
		
		ApiMessages msg = new ApiMessages("false");
		return new ResponseEntity(msg,HttpStatus.NOT_FOUND);
		
	}

}
