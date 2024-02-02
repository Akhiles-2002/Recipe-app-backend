package in.com.service;

import java.util.List;

import in.com.model.User;

public interface UserService {

	public User createUser(User user) throws Exception;
	
	public String deleteUser(Long userId) throws Exception;

	public List<User> getAllUsers();
	
	public User findUserById(Long userId) throws Exception;
	
	public User findUserByJwt(String jwt) throws Exception;

}
