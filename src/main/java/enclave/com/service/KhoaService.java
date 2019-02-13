package enclave.com.service;
import java.util.List;
import java.util.Optional;

import enclave.com.entities.Khoa;
public interface KhoaService {
	List<Khoa> findAllKhoa();
	Optional<Khoa> findById(Long id);
	Khoa findByIdv1(Long id);
	Khoa addKhoa (Khoa khoa);
	Khoa updateKhoa(Khoa khoa);
	boolean deleteKhoa (Long id);
}
