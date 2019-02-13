package enclave.com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enclave.com.entities.Khoa;
@Repository
public interface KhoaRepository extends JpaRepository<Khoa, Long>{
}
