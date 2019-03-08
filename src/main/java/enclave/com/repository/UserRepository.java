package enclave.com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enclave.com.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value ="Select * from user u where u.id_user = :id", nativeQuery=true)
	List<User> getUserIdUser(@Param("id") Integer id);
	
}
