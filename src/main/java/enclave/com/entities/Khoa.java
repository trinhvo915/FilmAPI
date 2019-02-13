package enclave.com.entities;
import java.io.Serializable;
import javax.persistence.*;



@SuppressWarnings("serial")
@Entity
@Table(name ="khoa")
public class Khoa implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKhoa;
	
	
	@Column(name = "nameKhoa")
	private String nameKhoa;

//	@OneToMany(mappedBy="khoa")
//	private List<SinhVien> listSinhvien ;
	
	public Khoa() {
		super();
	}


	public Khoa(Long idKhoa, String nameKhoa) {
		super();
		this.idKhoa = idKhoa;
		this.nameKhoa = nameKhoa;
	}


	public Khoa(Long idKhoa) {
		super();
		this.idKhoa = idKhoa;
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
