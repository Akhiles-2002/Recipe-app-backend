package in.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.hospital.entities.DoctorCredential;

@Repository
public interface DoctorCredentialRepository extends JpaRepository<DoctorCredential, Long> {

	@Query(value = "select * from doctor_credentials ul where ul.email like(:query)", nativeQuery = true)
	DoctorCredential findbyemailid(@Param("query") String query);

}
