package enclave.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enclave.com.entities.Khoa;
import enclave.com.repository.KhoaRepository;
import enclave.com.service.KhoaService;



@Service
public class KhoaServiceImpl implements KhoaService{
	@Autowired
	private KhoaRepository khoaRepository;

	@Override
	public List<Khoa> findAllKhoa() {
		return (List<Khoa>) khoaRepository.findAll();
	}

	@Override
	public Optional<Khoa> findById(Long id) {
		Optional<Khoa> khoa = khoaRepository.findById(id);
		return khoa;
	}
	
	@Override
	public Khoa addKhoa(Khoa khoa) {
		khoa = khoaRepository.save(khoa);
		return khoa;
	}

	@Override
	public Khoa updateKhoa(Khoa khoa) {
		khoa = khoaRepository.save(khoa);
		return khoa;
	}

	@Override
	public boolean deleteKhoa(Long id) {
		Optional<Khoa> khoa = khoaRepository.findById(id);
		if(khoa != null) {
			khoaRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Khoa findByIdv1(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

}
