package in.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hospital.entities.Admin;
import in.hospital.services.AdminService;
import in.hospital.userexception.AdminInvalidPasswordException;
import in.hospital.userexception.AdminInvalidUsernameException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/in/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/add-admin-record")
	public Admin addAdminRecord(@RequestBody Admin admin) throws Exception {
		return adminService.addAdminRecord(admin);
	}

	@PostMapping("/admin-login")
	String adminLogin(@RequestBody Admin admin) throws AdminInvalidUsernameException, AdminInvalidPasswordException {
		return adminService.adminLogin(admin.getEmail(), admin.getPassword());
	}

}
