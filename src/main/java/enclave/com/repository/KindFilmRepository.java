package enclave.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enclave.com.entities.KindFilm;




@Repository
public interface KindFilmRepository extends JpaRepository<KindFilm, Long> {

}
