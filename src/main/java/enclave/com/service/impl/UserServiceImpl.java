package enclave.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enclave.com.entities.User;
import enclave.com.repository.UserRepository;
import enclave.com.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAllUser() {
		List<User> listUser = userRepository.findAll();
		return listUser;
	}

	@Override
	public List<User> findById(Integer id) {
		return userRepository.getUserIdUser(id);	
	}

	@Override
	public User saveUser(User user) {
		 user =  userRepository.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> listUser() {
		List<User> listUser = userRepository.findAll(); 
		return listUser;
	}
	
	@Override
	public User getOneById(Integer id_user) {
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
	public void deleteUserById(Integer id_user) {
		userRepository.deleteById(id_user);
	}
	
}
