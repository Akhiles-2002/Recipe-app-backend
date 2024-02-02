package in.hospital.services;

import java.util.List;

import in.hospital.entities.Doctor;
import in.hospital.entities.Patient;

public interface DoctorService {

	public Doctor addDoctorRecord(Doctor doctor);

	public List<Doctor> getAllDoctorsRecord();

	public Doctor findDoctorById(Long doctorId);

	public Doctor updateDoctorRecordById(Long doctorId, Doctor product);

	public String deleteDoctorRecordById(Long doctorId);

	public List<Patient> findDoctorWithAppointment(Long doctorId);

	public List<Patient> patientsUnderDoctor(Long doctorId);

}
