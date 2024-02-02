package in.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hospital.entities.Doctor;
import in.hospital.entities.Patient;
import in.hospital.services.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/in/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/add-doctor-record")
	public Doctor addDoctorRecord(@RequestBody Doctor doctor) {
		return doctorService.addDoctorRecord(doctor);
	}

	@GetMapping("/get-all-records")
	public List<Doctor> getAllDoctorsRecord() {
		return doctorService.getAllDoctorsRecord();
	}

	@GetMapping("/find-doctor-by-id/{doctorId}")
	public Doctor findDoctorById(@PathVariable("doctorId") Long doctorId) {
		return doctorService.findDoctorById(doctorId);
	}

	@PutMapping("/update-record-by-id/{doctorId}")
	public Doctor updateDoctorRecordById(@PathVariable("doctorId") Long doctorId, @RequestBody Doctor doctor) {
		return doctorService.updateDoctorRecordById(doctorId, doctor);
	}

	@DeleteMapping("/delete-by-id/{doctorId}")
	public String deleteDoctorRecordById(@PathVariable("doctorId") Long doctorId) {
		return doctorService.deleteDoctorRecordById(doctorId);
	}

	@GetMapping("/check-doctor-appointment/{doctorId}")
	public List<Patient> findDoctorWithAppointment(@PathVariable("doctorId") Long doctorId) {
		return doctorService.findDoctorWithAppointment(doctorId);
	}

	@GetMapping("/list-of-patients/{doctorId}")
	public List<Patient> patientsUnderDoctor(@PathVariable("doctorId") Long doctorId) {
		return doctorService.patientsUnderDoctor(doctorId);
	}

}
