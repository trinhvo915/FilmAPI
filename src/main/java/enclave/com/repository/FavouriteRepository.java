package enclave.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long>{

}
