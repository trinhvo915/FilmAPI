package enclave.com.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name ="roles")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_role;
	
	@Column(name ="name_role")
	private String name_role;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//            mappedBy = "roles")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role",
			joinColumns =  @JoinColumn(name = "id_role"),
			inverseJoinColumns = @JoinColumn(name = "id_user"))
	private Set<User> users= new HashSet<>();

	public Role() {
		super();
	}
	
	public Role(Role role) {
		this.id_role = role.getId_role();
		this.name_role = role.getName_role();
	}
	
	public Role(Integer id_role, String name_role) {
		this.id_role = id_role;
		this.name_role = name_role;
	}
	
	public Role(Integer id_role) {
		super();
		this.id_role = id_role;
	}
	
	public Role(String name_role) {
		super();
		this.name_role = name_role;
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
	
/*
	public Set<User> getListUser() {
		return listUser;
	}

	public void setListUser(Set<User> listUser) {
		this.listUser = listUser;
	}
*/
}
