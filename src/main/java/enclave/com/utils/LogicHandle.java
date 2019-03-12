package enclave.com.utils;

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
		if(!listUser.isEmpty()){
			for (User userlist : listUser) {
				if(userlist.getUsername().equals(user.getUsername())){
					return false;
				}
			}
		}
		return true;
	}

	public static boolean functionCheckUser(List<User> listUser, User user) {
		boolean flag = false;
		if(!listUser.isEmpty()){
			for (User item : listUser){
				if(item.getId_user().equals(user.getId_user())){
					for (User itemm : listUser){
						if(itemm.getUsername().equals(user.getUsername())){
							System.out.println("Username :  "+itemm.getUsername());
							flag = true;
							break;
						}
					}	
				}
			}
		}
		if(flag==true)
			return true;
		return false;
	}

	public static boolean functionCheckFilm(List<Film> listFilm, Film film) {
		for (Film item : listFilm) {
			if(item.getId_film()==film.getId_film()){
				return true ;
			}
		}
		return false;
	}

}
