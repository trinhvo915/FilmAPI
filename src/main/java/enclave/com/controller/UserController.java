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
import enclave.com.service.impl.UserServiceImpl;
import enclave.com.utils.ApiMessages;
import enclave.com.utils.LogicHandle;
import enclave.com.utils.StringUtils;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public ResponseEntity<List<User>> GetAllUser(){
		List<User> listUser = userService.findAllUser();
		if(listUser.size()!=0){
			return new ResponseEntity<List<User>>(listUser,HttpStatus.OK) ;
		}
		ResponseEntity<List<User>> errorListUser = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return errorListUser;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/registerAnyAccount", method= RequestMethod.POST)
	public ResponseEntity<User> RegisterUser( @RequestBody(required = false) User user){
		//System.out.println("This is : "+user.getRoles());
		List<User> listUser = userService.findAllUser();
		boolean checkUsername = LogicHandle.functionCheckUsername(listUser,user);
		if(checkUsername){
			User userRegister = userService.saveUser(user);
			return new ResponseEntity<User>(userRegister, HttpStatus.CREATED) ;
		}
		String message = "Username is exited";
		return new ResponseEntity(message,HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value ="/update", method=RequestMethod.PUT)
	ResponseEntity<User> updateUser(@RequestBody(required = false) User user){
		
		List<User> listUser = userService.findAllUser();
		boolean checkFindUser = LogicHandle.functionCheckUser(listUser,user);
		if(!checkFindUser){
			User user_Update = userService.updateUser(user);
			if(user_Update!=null){
				return new ResponseEntity<User>(user,HttpStatus.OK);
			}
		}
		String message = "Username is exited";
		return new ResponseEntity(message,HttpStatus.NOT_FOUND);
	}
	
	//
	//Get information User via Id
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("id-{id}")
	public ResponseEntity<User> getUserById( @PathVariable(name = "id") Integer id){
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
			
			Set<Role> listRole = objUser.getRoles();
			for (Role role: listRole) {
				newUser.getRoles().add(roleRepository.findById(role.getId_role()).get());
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
			
			Set<Role> listRole = objUser.getRoles();
			Role role = new Role();
			role = roleRepository.findOneByName("USER");
			listRole.add(role);
			newUser.getRoles().add(roleRepository.findById((role.getId_role())).get());
			//Insert user into database
			userService.addUser(newUser);
			
			return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
		}
	}
	
	//
	//Edit User
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "edit/{id_user}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User objUser ,@PathVariable("id_user") Integer id_user){
		
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
				
				Set<Role> listRole = objUser.getRoles();
				Role role = new Role();
				role = roleRepository.findOneByName("USER");
				listRole.add(role);
				newUser.getRoles().add(roleRepository.findById(role.getId_role()).get());
				
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
	@RequestMapping(value = "del/{id_user}",method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable ("id_user")Integer id_user){
		
		//User does not exist
		if (userService.getOneById(id_user) == null) {
			ApiMessages err = new ApiMessages("Not found this user" );
			return new ResponseEntity(err, HttpStatus.NOT_FOUND);
		} else {
			userService.deleteUserById(id_user);
			ApiMessages msg = new ApiMessages("Deleted user " + id_user );
			return new ResponseEntity(msg, HttpStatus.OK);
		}
	}
	
}

