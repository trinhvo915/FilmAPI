package enclave.com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class User_Role {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "id_user")
	private long id_user;
	
	@Column(name = "id_role")
	private long id_role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public long getId_role() {
		return id_role;
	}

	public void setId_role(long id_role) {
		this.id_role = id_role;
	}

	public User_Role(long id, long id_user, long id_role) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_role = id_role;
	}

	public User_Role() {
		super();
	}
	
	
}
