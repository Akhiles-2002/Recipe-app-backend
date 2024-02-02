package in.hospital.services;

import in.hospital.entities.DoctorCredential;
import in.hospital.userexception.DoctorInvalidPasswordException;
import in.hospital.userexception.DoctorInvalidUsernameException;

public interface DoctorCredentialService {

	public DoctorCredential doctorSignUp(DoctorCredential doctorCredential) throws Exception;

	public String login(DoctorCredential doctorCredential)
			throws DoctorInvalidPasswordException, DoctorInvalidUsernameException;

}
