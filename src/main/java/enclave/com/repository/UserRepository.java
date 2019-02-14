package enclave.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enclave.com.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
