package enclave.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.entities.User;
import enclave.com.service.UserService;
import enclave.com.utils.StringUtils;

@RestController
@RequestMapping("login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	
	//Data input Object
	@PostMapping("auth")
	public ResponseEntity<User> login(@RequestBody User objUser){
		//Incorrect username or password
		
		//Decode password
		String password = StringUtils.md5(objUser.getPassword());
		System.out.println(password);
		if (userService.getUserByNameAndPassword(objUser.getUsername(), password) == null) {
			
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			//Get information of user login
			User userLogin = userService.getUserByNameAndPassword(objUser.getUsername(), password);
			
			return new ResponseEntity<User>(userLogin,HttpStatus.OK);
		}
		
	}
}