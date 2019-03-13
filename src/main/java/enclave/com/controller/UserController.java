package enclave.com.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.entities.Role;
import enclave.com.entities.User;
import enclave.com.repository.RoleRepository;
import enclave.com.repository.UserRepository;
import enclave.com.service.UserService;
import enclave.com.utils.ApiMessages;
import enclave.com.utils.StringUtils;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//
	//Get all User
	//
	@GetMapping("all")
	public ResponseEntity<List<User>> listUser(){
		List<User> listUser = userService.listUser();
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}
	
	
	//
	//Get information User via Id
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("id-{id}")
	public ResponseEntity<User> getUserById( @PathVariable(name = "id") long id){
		if (userService.getOneById(id) == null) {
			ApiMessages err = new ApiMessages("Can not found user id: " + id);
			return new ResponseEntity(err,HttpStatus.NOT_FOUND);
		} else {
			User objUser = userService.getOneById(id);
			return new ResponseEntity<User>(objUser, HttpStatus.OK);
		}
	}
	
	//
	//Get information User via username
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("username-{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable (name = "username") String username){
		if (userService.getUserByName(username) == null) {
			ApiMessages err = new ApiMessages("No found username " + username + " in system");
			return new ResponseEntity(err, HttpStatus.NOT_FOUND);
		} else {
			User objUser = userService.getUserByName(username);
			return new ResponseEntity<User>(objUser, HttpStatus.OK);
		}
	}
	
	//
	//Add user for Admin
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("add")
	public ResponseEntity<User> addUser(@RequestBody User objUser){
		//User already exists
		if (userService.getUserByName(objUser.getUsername()) != null) {
			ApiMessages err = new ApiMessages("User "+ objUser.getUsername() + " already exists in system");
			return new ResponseEntity(err, HttpStatus.NOT_FOUND);
		} else {
			//Encode password
			String enCodePWD = StringUtils.md5(objUser.getPassword());
			objUser.setPassword(enCodePWD);
			User newUser = new User(objUser);
			
			Set<Role> listRole = objUser.getRole();
			for (Role role: listRole) {
				newUser.getRole().add(roleRepository.findById(role.getId_role()).get());
			}
			//Insert user into database
			userService.addUser(newUser);
			
			return new ResponseEntity<User>(newUser, HttpStatus.OK);
		}
	}
	
	//
	//API register for new user on app
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("register")
	public ResponseEntity<User> register(@RequestBody User objUser){
		//User already exists
		if (userService.getUserByName(objUser.getUsername()) != null) {
			ApiMessages err = new ApiMessages("User "+ objUser.getUsername() + " already exists in system");
			return new ResponseEntity(err, HttpStatus.NOT_FOUND);
		} else {
			//Encode password
			String enCodePWD = StringUtils.md5(objUser.getPassword());
			objUser.setPassword(enCodePWD);
			User newUser = new User(objUser);
			
			Set<Role> listRole = objUser.getRole();
			Role role = new Role();
			role = roleRepository.findOneByName("USER");
			listRole.add(role);
			newUser.getRole().add(roleRepository.findById(role.getId_role()).get());
			//Insert user into database
			userService.addUser(newUser);
			
			return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
		}
	}
	
	//
	//Edit User
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "edit-{id_user}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User objUser ,@PathVariable("id_user") long id_user){
		
		//
		// Check ID user exist
		//
		if (!userRepository.findById(id_user).isPresent()) {
			ApiMessages err = new ApiMessages("Not found user!");
			return new ResponseEntity(err, HttpStatus.NOT_FOUND);
		} else {
			//
			// Check username exist
			//
			if (userRepository.getUserByName(objUser.getUsername()) != null) {
				ApiMessages err = new ApiMessages("Username " + objUser.getUsername() + "has been existed");
				return new ResponseEntity(err, HttpStatus.NOT_ACCEPTABLE);
			} else {
				User oldUser = userService.getOneById(id_user);
				User newUser = new User(oldUser.getId_user(), oldUser.getUsername(), objUser.getPassword(), objUser.getFullname(), objUser.getEmail());
				
				Set<Role> listRole = objUser.getRole();
				Role role = new Role();
				role = roleRepository.findOneByName("USER");
				listRole.add(role);
				newUser.getRole().add(roleRepository.findById(role.getId_role()).get());
				
				//Encode password
				String encodePWD = StringUtils.md5(objUser.getPassword());
				newUser.setPassword(encodePWD);
				
				userRepository.save(newUser);
				
				return new ResponseEntity<User>(newUser, HttpStatus.OK);
			}
		}
		
	}
	
	//
	//Delete User
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "del-{id_user}",method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable ("id_user")long id_user){
		
		//User does not exist
		if (userService.getOneById(id_user) == null) {
			ApiMessages err = new ApiMessages("Not found this user" );
			return new ResponseEntity(err, HttpStatus.NOT_FOUND);
		} else {
			userService.deleteUser(id_user);
			ApiMessages msg = new ApiMessages("Deleted user " + id_user );
			return new ResponseEntity(msg, HttpStatus.OK);
		}
	}
	
}
