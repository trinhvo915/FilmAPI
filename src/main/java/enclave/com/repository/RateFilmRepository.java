package enclave.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Rate;

@Repository
public interface RateFilmRepository extends JpaRepository<Rate, Long>{

}
