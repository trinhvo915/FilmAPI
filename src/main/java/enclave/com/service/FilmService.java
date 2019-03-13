package enclave.com.service;

import java.util.List;

import enclave.com.entities.Film;

public interface FilmService {
	
	public List<Film> getAllFilm();
	
	public Film getFilm(long id_film);
	
	public Film addFilm(Film film);
	
	public Film updateFilm(Film film);
	
	public boolean deleteFilm(long id_film);

	public List<Film> listLimitInforFilm();

	
}
