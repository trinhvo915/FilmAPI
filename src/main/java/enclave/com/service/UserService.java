package enclave.com.service;

import java.util.List;

import enclave.com.entities.User;

public interface UserService {
	
	List<User> findAllUser();
	List<User> findById(Integer id);
	User saveUser(User user);
	User updateUser(User user);
	
	
	public List<User> listUser();
	
	public User getUserByName(String name);
	
	public User getUserByNameAndPassword(String name, String password);
	
	public User getOneById(Integer id_user);
	
	public User addUser(User objUser);
	
	public void deleteUserById(Integer id_user);
	

}
