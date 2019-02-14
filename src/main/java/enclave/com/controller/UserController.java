package enclave.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.entities.User;
import enclave.com.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public ResponseEntity<User> LoginUser(@RequestBody User user){
		// TODO Auto-generated method stub
		return null;
	}
}
