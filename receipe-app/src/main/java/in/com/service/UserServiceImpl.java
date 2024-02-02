package in.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.config.JwtProvider;
import in.com.model.User;
import in.com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtProvider jwtProvider;

	@Override
	public User createUser(User user) throws Exception {
		User isExist = userRepository.findByEmailId(user.getEmailId());

		if (isExist != null) {
			throw new Exception("User Already Exist with :: " + isExist.getEmailId());
		} else {
			return userRepository.save(user);
		}
	}

	@Override
	public String deleteUser(Long userId) throws Exception {
		User user = userRepository.findById(userId).get();

		if (user != null) {
			userRepository.deleteById(userId);
			return "Record Deleted Successfully!...";
		} else {
			throw new Exception("Id is not available for :: " + userId);
		}

	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(Long userId) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new Exception("User not found with id :: " + userId);
		}
	}

	@Override
	public User findUserByJwt(String jwt) throws Exception {

		String emailId = jwtProvider.getEmailFromJwtToken(jwt);
		if (emailId == null) {
			throw new Exception("Provide valid Jwt Token!....");
		}

		User user = userRepository.findByEmailId(emailId);
		if (user == null) {
			throw new Exception("User is not found with emailId :: " + emailId);
		}

		return user;
	}

}
