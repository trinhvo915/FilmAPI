package enclave.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.entities.User;
import enclave.com.service.impl.UserServiceImpl;
import enclave.com.untils.LogicHandle;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<User>> GetAllUser(){
		List<User> listUser = userService.findAllUser();
		if(listUser.size()!=0){
			return new ResponseEntity<List<User>>(listUser,HttpStatus.OK) ;
		}
		ResponseEntity<List<User>> errorListUser = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return errorListUser;
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public ResponseEntity<User> RegisterUser( @RequestBody(required = false) User user){
		//System.out.println("This is : "+user.getRoles());
		List<User> listUser = userService.findAllUser();
		boolean checkUsername = LogicHandle.functionCheckUsername(listUser,user);
		if(checkUsername){
			User userRegister = userService.saveUser(user);
			return new ResponseEntity<User>(userRegister, HttpStatus.CREATED) ;
		}
		ResponseEntity<User> errorUser = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return errorUser;
	}
	
}
