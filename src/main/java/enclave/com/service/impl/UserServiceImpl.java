package enclave.com.service.impl;

import java.util.List;

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
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
