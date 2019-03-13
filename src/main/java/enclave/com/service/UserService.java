package enclave.com.service;

import java.util.List;

import enclave.com.entities.User;

public interface UserService {
	public List<User> listUser();
	
	public User getUserByName(String name);
	
	public User getUserByNameAndPassword(String name, String password);
	
	public User getOneById(long id_user);
	
	public User addUser(User objUser);
	
	public void deleteUser(long id_user);
}
