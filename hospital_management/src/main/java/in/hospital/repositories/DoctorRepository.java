package in.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.hospital.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

//	@Query("SELECT doc FROM Doctor doc LEFT JOIN FETCH doc.patientId WHERE doc.doctorId = :doctorId")
//	Doctor findDoctorWithPatients(@Param("doctorId") Long doctorId);

}
