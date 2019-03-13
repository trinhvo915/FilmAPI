package enclave.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query(value = "SELECT * FROM roles WHERE name_role = :name_role", nativeQuery = true)
	Role findOneByName(@Param("name_role") String name_role);
}
