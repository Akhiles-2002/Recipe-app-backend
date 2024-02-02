package in.hospital.services;

import in.hospital.entities.Admin;
import in.hospital.userexception.AdminInvalidPasswordException;
import in.hospital.userexception.AdminInvalidUsernameException;

public interface AdminService {

	public Admin addAdminRecord(Admin Admin) throws Exception;

	String adminLogin(String email, String password)
			throws AdminInvalidUsernameException, AdminInvalidPasswordException;

}
