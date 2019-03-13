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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;
	
	@Column(name = "username")
	private String username;
	
	@Column(name ="password")
	private String password;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name ="email")
	private String email;
		
	@ManyToMany(fetch = FetchType.LAZY	)
	@JoinTable(name = "user_role",
		joinColumns =  @JoinColumn(name = "id_user"),
		inverseJoinColumns = @JoinColumn(name = "id_role"))
	@JsonIgnoreProperties("users")
	private Set<Role> roles = new HashSet<>();;
	
	@OneToMany(mappedBy="user")
	private Set<Comment> listComment = new HashSet<>();;
	
	@OneToMany(mappedBy="user")
	private Set<Favourite> listFavourite = new HashSet<>();;
	
	@OneToMany(mappedBy="user")
	private Set<Rate> listRate = new HashSet<>();
	
	public User() {
		super();
	}
	public User(Integer id_user, String username, String password,
			String fullname, String email) {
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
	}
	
	
	public User( String username, String password,
			String fullname, String email) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
	}
	
	public User(Integer id_user, String username, String password,
			String fullname, String email, Set<Role> roles) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.roles = roles;
	}
	
	public User(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.fullname = user.getFullname();
		this.email = user.getEmail();
	}
	
	
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
/*
	public Set<Favourite> getListFavourite() {
		return listFavourite;
	}
	
	public void setListFavourite(Set<Favourite> listFavourite) {
		this.listFavourite = listFavourite;
	}
	
	public Set<Comment> getListComment() {
		return listComment;
	}
	
	public void setListComment(Set<Comment> listComment) {
		this.listComment = listComment;
	}
*/
	
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", username=" + username
				+ ", password=" + password + ", fullname=" + fullname
				+ ", email=" + email + ", roles=" + roles + "]";
	}

	
}
