package in.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hospital.entities.DoctorCredential;
import in.hospital.services.DoctorCredentialService;
import in.hospital.userexception.DoctorInvalidPasswordException;
import in.hospital.userexception.DoctorInvalidUsernameException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/in/doctor")
public class DoctorCredentialController {

	@Autowired
	private DoctorCredentialService doctorCredentialService;

	@PostMapping("/signup-doctor")
	public DoctorCredential doctorSignUp(@RequestBody DoctorCredential doctorCredential) throws Exception {
		System.out.println(doctorCredential);
		return doctorCredentialService.doctorSignUp(doctorCredential);
	}

//	@GetMapping("/login/{email}/{password}")
//	public String doctorLogin(@PathVariable String username, @PathVariable String password) {
//		System.out.println("Username is :: " + username);
//		System.out.println("Password is :: " + password);
//		return doctorCredentialService.doctorLogin(username, password);
//	}

//	@GetMapping("/login/{email}/{password}")
//	public ResponseEntity<String> login(@PathVariable String email, @PathVariable String password)
//	{
//		return ResponseEntity.ok(doctorCredentialService.doctorLogin(email, password));
//	}

	@PostMapping("/login-doctor")
	public String login(@RequestBody DoctorCredential doctorCredential) {
		System.out.println("Doctor Credential is " + doctorCredential);
		try {
			return doctorCredentialService.login(doctorCredential);
		} catch (DoctorInvalidPasswordException | DoctorInvalidUsernameException e) {
			return e.getMessage();
		}
	}

}
