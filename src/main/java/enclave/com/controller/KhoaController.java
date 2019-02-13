package enclave.com.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enclave.com.dto.KhoaDto;
import enclave.com.entities.Khoa;
import enclave.com.service.impl.KhoaServiceImpl;
import enclave.com.untils.ConvertKhoa;




@RestController
@RequestMapping("/khoa")
public class KhoaController {
	
	@Autowired
	KhoaServiceImpl khoaServiceImpl;
	
    @RequestMapping(value = "/all", method = {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity<List<KhoaDto>> findAllKhoa(){
    	List<KhoaDto> listKhoaDto = ConvertKhoa.ListKhoaToListKhoaDto(khoaServiceImpl.findAllKhoa());
    	if(listKhoaDto.isEmpty()) {
    		ResponseEntity<List<KhoaDto>> resKhoaNotFind = new ResponseEntity<>(HttpStatus.NO_CONTENT);
    		return resKhoaNotFind;
    	}
    	return new ResponseEntity<>(listKhoaDto,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/findKhoa/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Khoa> getKhoa(@PathVariable("id") Integer id){
    	Optional<Khoa> khoa = khoaServiceImpl.findById((long)id);
    	if(khoa == null) {
    		ResponseEntity<Khoa> resKhoaDtoNoFind = new ResponseEntity<>(HttpStatus.NO_CONTENT);
    		return resKhoaDtoNoFind;
    	}
    	
    	return new ResponseEntity<>(khoa.get(),HttpStatus.OK);
    }
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public ResponseEntity<KhoaDto> createKhoa(@RequestBody KhoaDto khoaDto){
    	Khoa khoa = ConvertKhoa.KhoaDtoToKhoa(khoaDto);
    	KhoaDto dataKhoaDto = ConvertKhoa.KhoaToKhoaDto(khoaServiceImpl.addKhoa(khoa));
    	return new ResponseEntity<KhoaDto>(dataKhoaDto,HttpStatus.OK);	
    }
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public ResponseEntity<KhoaDto> updateKhoa(@RequestBody KhoaDto khoaDto){
    	
    	Khoa khoa = ConvertKhoa.KhoaDtoToKhoa(khoaDto);
    	if(khoa == null) {
    		 ResponseEntity<KhoaDto> khoaDtoError = new ResponseEntity<KhoaDto>(HttpStatus.NO_CONTENT);
    		 return khoaDtoError;
    	}
    	KhoaDto dataKhoaDto = ConvertKhoa.KhoaToKhoaDto(khoaServiceImpl.updateKhoa(khoa));
    	return new ResponseEntity<KhoaDto>(dataKhoaDto,HttpStatus.OK);	
    }
    
    @RequestMapping(value ="/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Khoa> deleteKhoa(@PathVariable("id") long id){
    	Optional<Khoa> khoa  = khoaServiceImpl.findById(id);
    	if(khoa == null) {
    		@SuppressWarnings("unused")
			ResponseEntity<Khoa> khoaError = new  ResponseEntity<Khoa>(HttpStatus.NO_CONTENT);
    	}
    	khoaServiceImpl.deleteKhoa(id);
    	return ResponseEntity.ok().build();
    }
	
}
