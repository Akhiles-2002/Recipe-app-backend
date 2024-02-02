package in.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.hospital.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	@Query(value = "select * from admin ul where ul.email like(:query)", nativeQuery = true)
	Admin findbyemailid(@Param("query") String query);

}
