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

import in.hospital.entities.Patient;
import in.hospital.services.PatientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/in/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/add-patient-record")
	public Patient addPatientRecord(@RequestBody Patient patient) {
		return patientService.addPatientRecord(patient);
	}

	@GetMapping("/get-all-records")
	public List<Patient> getAllPatientsRecord() {
		return patientService.getAllPatientsRecord();
	}

	@GetMapping("/find-patient-by-id/{patientId}")
	public Patient findPatientById(@PathVariable("patientId") Long patientId) {
		return patientService.findPatientById(patientId);
	}

	@PutMapping("/update-record-by-id/{patientId}")
	public Patient updatePatientRecordById(@PathVariable("patientId") Long patientId, @RequestBody Patient patient) {
		return patientService.updatePatientRecordById(patientId, patient);
	}

	@DeleteMapping("/delete-by-id/{patientId}")
	public String deletePatientRecordById(@PathVariable("patientId") Long patientId) {
		return patientService.deletePatientRecordById(patientId);
	}

	@GetMapping("/appoint-doctor/{doctorId}/{patientId}")
	public String appointDoctorToPatient(@PathVariable("doctorId") Long doctorId,
			@PathVariable("patientId") Long patientId) {
		return patientService.appointDoctorToPatient(doctorId, patientId);
	}

}
