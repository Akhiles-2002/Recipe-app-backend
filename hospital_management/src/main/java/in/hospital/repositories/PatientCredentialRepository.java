package in.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.hospital.entities.PatientCredential;

@Repository
public interface PatientCredentialRepository extends JpaRepository<PatientCredential, Long> {

	@Query(value = "select * from Patient_Credentials pc where pc.username =(:username)", nativeQuery = true)
	PatientCredential findByUsername(@Param("username") String username);

}
