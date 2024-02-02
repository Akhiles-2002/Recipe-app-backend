package in.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmailId(String email);

}
