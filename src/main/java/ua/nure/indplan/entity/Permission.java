package ua.nure.indplan.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@Table(name="permission")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable, GrantedAuthority {
	private static final long serialVersionUID = 1L;
	private int id;
	private String permissionname;
	private Set<Role> roles;

	public Permission() {
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
	public String getPermissionname() {
		return this.permissionname;
	}

	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}


	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="permissions", fetch=FetchType.EAGER)
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	@Transient
	public String getAuthority() {
		return getPermissionname();
	}

}