package in.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hospital.entities.Admin;
import in.hospital.repositories.AdminRepository;
import in.hospital.userexception.AdminInvalidPasswordException;
import in.hospital.userexception.AdminInvalidUsernameException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Admin addAdminRecord(Admin admin) throws Exception {
		Admin admin1 = adminRepo.findbyemailid(admin.getEmail());
		if(admin1 != null) {
			return adminRepo.save(admin);
		} else {
			throw new Exception("EmailId is Already present :: " + admin.getEmail());
		}
	}

	@Override
	public String adminLogin(String email, String password)
			throws AdminInvalidUsernameException, AdminInvalidPasswordException {
		Admin admin = adminRepo.findbyemailid(email);

		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				return "Login Successfully, WELCOME!...";
			} else {
				throw new AdminInvalidPasswordException("Invalid Password!...");
			}
		} else {
			throw new AdminInvalidUsernameException("Email not found. Kindly Create Account!...");
		}
	}



}
