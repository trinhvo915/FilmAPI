package enclave.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

}
