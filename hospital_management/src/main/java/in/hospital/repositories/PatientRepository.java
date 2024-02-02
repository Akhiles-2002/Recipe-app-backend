package in.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.hospital.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
