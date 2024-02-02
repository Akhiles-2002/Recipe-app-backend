package in.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hospital.entities.Doctor;
import in.hospital.entities.Patient;
import in.hospital.repositories.DoctorRepository;
import in.hospital.repositories.PatientRepository;
import in.hospital.userexception.DoctorInvalidIdException;
import in.hospital.userexception.PatientInvalidIdException;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Patient addPatientRecord(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatientsRecord() {
		return patientRepository.findAll();
	}

	@Override
	public Patient findPatientById(Long patientId) {
		Patient patient = null;
		try {
			patient = patientRepository.findById(patientId)
					.orElseThrow(() -> new PatientInvalidIdException("Invalid patient ID: " + patientId));
		} catch (PatientInvalidIdException e) {
			e.getMessage();
		}

		return patient;
	}

	@Override
	public Patient updatePatientRecordById(Long patientId, Patient patient) {
		Patient patient1 = null;
		try {
			patient1 = patientRepository.findById(patientId)
					.orElseThrow(() -> new PatientInvalidIdException("Invalid patient ID: " + patientId));
		} catch (PatientInvalidIdException e) {
			e.getMessage();
		}

		if (patient != null) {
			patient1.setPatientId(patientId);
			patient1.setName(patient.getName());
			patient1.setAge(patient.getAge());
			patient1.setPhoneNumber(patient.getPhoneNumber());
			patient1.setAddress(patient.getAddress());
			patient1.setDiseaseDetails(patient.getDiseaseDetails());
		}
		return patientRepository.save(patient1);
	}

	@Override
	public String deletePatientRecordById(Long patientId) {
		Patient patient = null;
		String message = "Record Not Found, Try for Another Id!...";

		try {
			patient = patientRepository.findById(patientId)
					.orElseThrow(() -> new PatientInvalidIdException("Invalid patient ID: " + patientId));
		} catch (PatientInvalidIdException e) {
			return e.getMessage();
		}

		if (patient != null) {
			patient.setDoctorId(null);
			patientRepository.deleteById(patientId);
			message = "Record Deleted Successfully!...";
		}
		return message;
	}

	@Override
	public String appointDoctorToPatient(Long doctorId, Long patientId) {
		String message = "Appoint Failed doctor to patient!...";

		// Check if doctorId is valid
		Doctor doctor = null;
		try {
			doctor = doctorRepository.findById(doctorId)
					.orElseThrow(() -> new DoctorInvalidIdException("Invalid doctor ID: " + doctorId));
		} catch (DoctorInvalidIdException e) {
			return e.getMessage();
		}

		// Check if patientId is valid
		Patient patient = null;
		try {
			patient = patientRepository.findById(patientId)
					.orElseThrow(() -> new PatientInvalidIdException("Invalid patient ID: " + patientId));
		} catch (PatientInvalidIdException e) {
			return e.getMessage();
		}

		if (patient != null && doctor != null) {
			patient.setDoctorId(doctor);
			patientRepository.save(patient);
			message = "Doctor is successfully Assigned to patient";
		}

		return message;
	}

//	public String appointDoctorToPatient(Long doctorId, Long patientId) {
//		String message = "Appoint Failed doctor to patient!...";
//
//		Patient patient = patientRepository.findById(patientId).get();
//		Doctor doctor = doctorRepository.findById(doctorId).get();
//
//		if (patient != null && doctor != null) {
//			patient.setDoctorId(doctor);
//			patientRepository.save(patient);
//			message = "Doctor is successfully Assigned to patient";
//		}
//
//		return message;
//	}

}
