package in.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hospital.entities.Doctor;
import in.hospital.entities.Patient;
import in.hospital.repositories.DoctorRepository;
import in.hospital.userexception.DoctorInvalidIdException;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctorRecord(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctorsRecord() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor findDoctorById(Long doctorId) {
		Doctor doctor = null;
		try {
			doctor = doctorRepository.findById(doctorId)
					.orElseThrow(() -> new DoctorInvalidIdException("Invalid doctor ID: " + doctorId));
		} catch (DoctorInvalidIdException e) {
			e.getMessage();
		}

		return doctor;
	}

	@Override
	public Doctor updateDoctorRecordById(Long doctorId, Doctor doctor) {
		Doctor doctor1 = doctorRepository.findById(doctorId).get();
		if (doctor != null) {
			doctor1.setDoctorId(doctorId);
			doctor1.setDoctorName(doctor.getDoctorName());
			doctor1.setSpecialization(doctor.getSpecialization());
			doctor1.setYearsOfExperience(doctor.getYearsOfExperience());
		}
		return doctorRepository.save(doctor1);
	}

	@Override
	public String deleteDoctorRecordById(Long doctorId) {
		Doctor doctor = null;
		try {
			doctor = doctorRepository.findById(doctorId)
					.orElseThrow(() -> new DoctorInvalidIdException("Invalid doctor ID: " + doctorId));
		} catch (DoctorInvalidIdException e) {
			e.getMessage();
		}
		String message = "Record Not Found, Try for Another Id!...";
		if (doctor != null) {
			doctorRepository.deleteById(doctorId);
			message = "Record Deleted Successfully!...";
		}
		return message;
	}

	@Override
	public List<Patient> findDoctorWithAppointment(Long doctorId) {
		Doctor doctor = null;
		List<Patient> patient = null;
		try {
			doctor = doctorRepository.findById(doctorId)
					.orElseThrow(() -> new DoctorInvalidIdException("Invalid doctor ID: " + doctorId));
		} catch (DoctorInvalidIdException e) {
			e.getMessage();
		}
		if (doctor != null) {
			patient = doctor.getPatientId();
		}
		return patient;
	}

	@Override
	public List<Patient> patientsUnderDoctor(Long doctorId) {

		Doctor doctor = doctorRepository.findById(doctorId).get();
		return doctor.getPatientId();
	}
}
