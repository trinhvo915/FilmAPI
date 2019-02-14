package enclave.com.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_user;
	
	@Column(name = "username")
	private String username;
	
	@Column(name ="password")
	private String password;
	
	@Column(name = "fullname")
	private String fullname;
	
	@ManyToOne
	@JoinColumn(name ="id_role")
	private Role role;
	
	public User() {
		super();
	}

	public User(Integer id_user, String username, String password, String fullname, Role role) {
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
	}
	
	/* Leo is wrote */
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	// ******//

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	
	
	
	
	
	
	
	

}
