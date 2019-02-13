package enclave.com.untils;

import java.util.ArrayList;
import java.util.List;

import enclave.com.dto.KhoaDto;
import enclave.com.entities.Khoa;



public class ConvertKhoa {
	
	/*
	 * Convert KhoaDto to Khoa
	 * */
	public static Khoa KhoaDtoToKhoa(KhoaDto khoaDto) {
		return new Khoa(khoaDto.getIdKhoa(),khoaDto.getNameKhoa());
	}
	
	/*
	 * Convert List KhoaDto to List Khoa
	 * */
	public static List<Khoa> ListKhoaDtoToKhoa(List<KhoaDto> listKhoaDtos){
		List<Khoa> listKhoa = new ArrayList<Khoa>();
		for(KhoaDto item : listKhoaDtos) {
			listKhoa.add(new Khoa(item.getIdKhoa(),item.getNameKhoa()));
		}
		return listKhoa;
	}
	
	/*
	 *  Convert Khoa to KhoaDto 
	 * */
	public static KhoaDto KhoaToKhoaDto(Khoa khoa) {
		return new KhoaDto(khoa.getIdKhoa(),khoa.getNameKhoa());
	}
	
	/*
	 *  Convert List Khoa to List KhoaDto
	 * */
	public static List<KhoaDto> ListKhoaToListKhoaDto(List<Khoa> listKhoas){
		List<KhoaDto> listKhoaDto = new ArrayList<KhoaDto>();
		for(Khoa item : listKhoas) {
			listKhoaDto.add(new KhoaDto(item.getIdKhoa(),item.getNameKhoa()));
		}
		return listKhoaDto;
	}

}
