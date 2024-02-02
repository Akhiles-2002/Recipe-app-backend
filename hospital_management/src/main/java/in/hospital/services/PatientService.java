package in.hospital.services;

import java.util.List;

import in.hospital.entities.Patient;

public interface PatientService {

	public Patient addPatientRecord(Patient patient);

	public List<Patient> getAllPatientsRecord();

	public Patient findPatientById(Long patientId);

	public Patient updatePatientRecordById(Long patientId, Patient patient);

	public String deletePatientRecordById(Long patientId);

	public String appointDoctorToPatient(Long doctorId, Long patientId);

}
