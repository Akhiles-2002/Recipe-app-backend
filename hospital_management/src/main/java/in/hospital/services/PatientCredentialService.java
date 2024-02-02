package in.hospital.services;

import in.hospital.entities.PatientCredential;
import in.hospital.userexception.PatientInvalidPasswordException;
import in.hospital.userexception.PatientInvalidUsernameException;

public interface PatientCredentialService {

	public PatientCredential patientSignUp(PatientCredential patientCredential) throws Exception;

	public String patientLogin(PatientCredential patientCredential)
			throws PatientInvalidPasswordException, PatientInvalidUsernameException;

}
