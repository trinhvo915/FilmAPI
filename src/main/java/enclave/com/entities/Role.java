package enclave.com.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name ="roles")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_role;
	
	@Column(name ="name_role")
	private String name_role;
	
	@OneToMany(mappedBy="role")
	private Set<User> listUser;
	

	public Role() {
		super();
	}
	
	public Role(Integer id_role, String name_role, Set<User> listUser) {
		this.id_role = id_role;
		this.name_role = name_role;
		this.listUser = listUser;
	}



	public Integer getId_role() {
		return id_role;
	}
	public void setId_role(Integer id_role) {
		this.id_role = id_role;
	}

	public String getName_role() {
		return name_role;
	}

	public void setName_role(String name_role) {
		this.name_role = name_role;
	}

	public Set<User> getListUser() {
		return listUser;
	}

	public void setListUser(Set<User> listUser) {
		this.listUser = listUser;
	}
	
	
	
	
	

}
