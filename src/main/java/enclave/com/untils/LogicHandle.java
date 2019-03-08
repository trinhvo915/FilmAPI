package enclave.com.untils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import enclave.com.entities.Film;
import enclave.com.entities.User;

public class LogicHandle {
	
	public static List<Film> functionRandomFilm(List<Film> listFilm ){
		List<Film> listfilmramdom = new ArrayList<Film>();		
		Random random = new Random();
		for(int i = 0 ; i < 12; i++){
			int index = random.nextInt(listFilm.size());
			Film film = listFilm.get(index);
			listfilmramdom.add(film);
			listFilm.remove(index);
		}
		if(listfilmramdom.size()==0){
			return null;
		}
		return listfilmramdom;
	}

	public static boolean functionCheckUsername(List<User> listUser, User user) {
		for (User userlist : listUser) {
			if(userlist.getUsername().equals(user.getUsername())){
				return false;
			}
		}
		return true;
	}

}
