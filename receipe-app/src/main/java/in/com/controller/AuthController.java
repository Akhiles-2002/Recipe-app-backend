package in.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.config.JwtProvider;
import in.com.model.User;
import in.com.repository.UserRepository;
import in.com.request.LoginRequest;
import in.com.response.AuthResponse;
import in.com.service.CustomUserDetailService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomUserDetailService customUserDetails;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private PasswordEncoder passwordEncorder;

	@PostMapping("/signup")
	public AuthResponse createUser(@RequestBody User user) throws Exception {

		String emailId = user.getEmailId();
		String password = user.getPassword();
		String fullName = user.getFullName();

		User isExistEmail = userRepository.findByEmailId(emailId);

		if (isExistEmail != null) {
			throw new Exception("Email is already used with another account");
		}

		User createdUser = new User();
		createdUser.setEmailId(emailId);
		createdUser.setPassword(passwordEncorder.encode(password));
		createdUser.setFullName(fullName);

		// User saveUser = userRepository.save(createdUser);
		userRepository.save(createdUser);

		Authentication authentication = new UsernamePasswordAuthenticationToken(emailId, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.generateToken(authentication);
		AuthResponse response = new AuthResponse();
		response.setJwt(token);
		response.setMessage("Signup successfully");

		return response;
	}

	@PostMapping("/signin")
	public AuthResponse signInHandler(@RequestBody LoginRequest loginRequest) {
		String username = loginRequest.getEmailId();
		String password = loginRequest.getPassword();

		Authentication authentication = authenticate(username, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.generateToken(authentication);
		AuthResponse response = new AuthResponse();
		response.setJwt(token);
		response.setMessage("Signin successfully");

		return response;
	}

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserDetails.loadUserByUsername(username);

		if (userDetails == null) {
			throw new BadCredentialsException("User not found");
		}
		if (!passwordEncorder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Password");
		}

		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}

}
