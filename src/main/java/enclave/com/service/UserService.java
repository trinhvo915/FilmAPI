package enclave.com.service;

import java.util.List;

import enclave.com.entities.User;

public interface UserService {
	
	List<User> findAllUser();
	User findById(Integer id);
	
	User saveUser(User user);
	User updateUser(User user);
	
	boolean deleteUser(Integer id);

}
