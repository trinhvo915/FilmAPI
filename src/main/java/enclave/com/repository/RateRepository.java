package enclave.com.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
	
	@Query(value = "SELECT r.score FROM rate_film AS r WHERE r.id_film = :id_film", nativeQuery = true)
	ArrayList<Integer> listScore(@Param("id_film") long id_film);
}
