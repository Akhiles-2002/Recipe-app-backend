package in.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import in.com.model.User;
import in.com.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

//	@PostMapping("/users/add")
//	public User createUser(@RequestBody User user) throws Exception {
//		return userService.createUser(user);
//	}
//
//	@DeleteMapping("/users/delete/{userId}")
//	public String deleteUser(@PathVariable("userId") Long userId) throws Exception {
//		return userService.deleteUser(userId);
//	}
//	
//	@GetMapping("/users/get-all-users")
//	public List<User> getAllUser() throws Exception {
//		return userService.getAllUsers();
//	}
 
	@GetMapping("/api/users/profile")
	public User findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.findUserByJwt(jwt);
		return user;
	}

}
