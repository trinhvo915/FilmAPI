package enclave.com.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import enclave.com.entities.Rate;

@Repository
public interface RateFilmRepository extends JpaRepository<Rate, Long>{
	
	//Get list score a film
	@Query(value = "SELECT r.score FROM rate_film AS r WHERE r.id_film = :id_film", nativeQuery = true)
	ArrayList<Integer> listScore(@Param("id_film") long id_film);
	
	//Get score user rated film
	@Query(value = "SELECT r.score FROM rate_film AS r WHERE r.id_film = :id_film AND r.id_user = :id_user", nativeQuery = true)
	Integer getScore(@Param("id_film") long id_film, @Param("id_user") long id_user);
	
	//Update score
	@Transactional
	@Modifying
	@Query (value = "UPDATE rate_film SET score = :score WHERE id_film = :id_film AND id_user = :id_user", nativeQuery = true)
	void updateScore(@Param("id_film") long id_film, @Param("id_user") long id_user, @Param("score") float score);
}
