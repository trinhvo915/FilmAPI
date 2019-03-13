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
	@Query(value = "SELECT u.* FROM users AS u WHERE u.username = :name", nativeQuery = true)
	User getUserByName(@Param("name") String name);
	
	@Query(value = "SELECT u.*,r.* FROM users AS u INNER JOIN user_role AS ur ON u.id_user = ur.id_user INNER JOIN roles AS r ON ur.id_role = r.id_role WHERE u.username = :name AND u.password = :password", nativeQuery = true)
	User getUserByNameAndPassword(@Param("name") String name, @Param("password") String password);
	
	@Query(value = "UPDATE users SET password = :password, fullname = :fullname, email = :email WHERE id_user = :id_user", nativeQuery = true)
	User editUser(@Param("id_user") long id_user,@Param("password") String password,@Param("fullname") String fullname,@Param("email") String email);
	
}
