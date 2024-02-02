package in.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.com.model.Receipe;

@Repository
public interface ReceipeRepository extends JpaRepository<Receipe, Long> {

}
