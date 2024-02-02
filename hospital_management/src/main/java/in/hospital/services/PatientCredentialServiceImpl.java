package in.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hospital.entities.PatientCredential;
import in.hospital.repositories.PatientCredentialRepository;
import in.hospital.userexception.PatientInvalidPasswordException;
import in.hospital.userexception.PatientInvalidUsernameException;

@Service
public class PatientCredentialServiceImpl implements PatientCredentialService {

	@Autowired
	private PatientCredentialRepository patientCredentialRepository;

	@Override
	public PatientCredential patientSignUp(PatientCredential patientCredential) throws Exception {
		PatientCredential patientByUsername = patientCredentialRepository
				.findByUsername(patientCredential.getUsername());
		if (patientByUsername != null) {
			return patientCredentialRepository.save(patientCredential);
		} else {
			throw new Exception("EmailId is Already present :: " + patientCredential.getUsername());
		}
	}

	@Override
	public String patientLogin(PatientCredential patientCredential)
			throws PatientInvalidPasswordException, PatientInvalidUsernameException {
		PatientCredential patientCred = patientCredentialRepository.findByUsername(patientCredential.getUsername());

		if (patientCred != null) {
			if (patientCred.getPassword().equals(patientCredential.getPassword())) {
				return "Login Successfully, WELCOME!...";
			} else {
				throw new PatientInvalidPasswordException("Invalid Password!...");
			}
		} else {
			throw new PatientInvalidUsernameException("Username not found. Kindly Create Account!...");
		}
	}

}
