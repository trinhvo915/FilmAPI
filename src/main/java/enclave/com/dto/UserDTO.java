package enclave.com.dto;

import java.util.Set;

import enclave.com.entities.Role;

public class UserDTO {
	private long id_user;
	private String success;
	private String fullname;
	private String email;
	private Set<Role> role;
	
	
	public long getId_user() {
		return id_user;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	public UserDTO(long id_user, String success, String fullname, String email, Set<Role> role) {
		super();
		this.id_user = id_user;
		this.success = success;
		this.fullname = fullname;
		this.email = email;
		this.role = role;
	}
	
	public UserDTO(String success) {
		super();
		this.success = success;
	}
	
	public UserDTO() {
		super();
	}
	
}
