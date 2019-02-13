package enclave.com.dto;
public class KhoaDto {
	
	private Long idKhoa;
	private String nameKhoa;

	
	public KhoaDto() {
		super();
	}


	public KhoaDto(Long idKhoa, String nameKhoa) {
		super();
		this.idKhoa = idKhoa;
		this.nameKhoa = nameKhoa;
	}


	public Long getIdKhoa() {
		return idKhoa;
	}


	public void setIdKhoa(Long idKhoa) {
		this.idKhoa = idKhoa;
	}


	public String getNameKhoa() {
		return nameKhoa;
	}


	public void setNameKhoa(String nameKhoa) {
		this.nameKhoa = nameKhoa;
	}
}
