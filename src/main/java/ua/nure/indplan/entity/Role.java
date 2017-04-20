package ua.nure.indplan.entity;

import java.io.Serializable;
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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable, GrantedAuthority {
	private static final long serialVersionUID = 1L;
	private int id;
	private String rolename;
	private Set<Permission> permissions;
	private Set<User> users;

	public Role() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(unique=true, nullable=false, length=50)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	//bi-directional many-to-many association to Permission
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="role_permission"
		, joinColumns={
			@JoinColumn(name="role_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="permission_id", nullable=false)
			}
		)
	public Set<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}


	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="roles", fetch=FetchType.EAGER)
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}


	@Override
	@Transient
	public String getAuthority() {
		return getRolename();
	}

}