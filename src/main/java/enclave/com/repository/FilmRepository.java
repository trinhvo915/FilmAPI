package enclave.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
	
	//@Query(value ="SELECT * Film FROM  LIMIT 10 ", nativeQuery = true) 
	
//	@Query("select c from Film c where c.name_vn like %?1")
//	public List<Film> findByNameEndsWith(String chars);

}
