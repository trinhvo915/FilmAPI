package enclave.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enclave.com.entities.User;
import enclave.com.repository.UserRepository;
import enclave.com.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> listUser() {
		List<User> listUser = userRepository.findAll(); 
		return listUser;
	}
	
	@Override
	public User getOneById(long id_user) {
		Optional<User> objUser = userRepository.findById(id_user);
		return objUser.get();
	}

	@Override
	public User getUserByName(String name) {
		User objUser = userRepository.getUserByName(name);
		return objUser;
	}

	@Override
	public User getUserByNameAndPassword(String name, String password) {
		User objUser = userRepository.getUserByNameAndPassword(name, password);
		return objUser;
	}

	@Override
	public User addUser(User objUser) {
		userRepository.save(objUser);
		return objUser;
	}
	
	@Override
	public void deleteUser(long id_user) {
		userRepository.deleteById(id_user);
	}

}
