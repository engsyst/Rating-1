package net.ua.entity;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = 4356423098157750311L;

	@Id
	@GeneratedValue
	@Column(name = "id", length = 11, nullable = false)
	private int userId;

	@Column(name = "Login", length = 16, nullable = false, unique = true)
	@Size(min = 1, max = 16)
	private String login;

	@Column(name = "Email")
	@Email
	private String email;

	@Column(name = "Password", length = 32, nullable = false)
	@Size(min = 1, max = 32)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateTime", columnDefinition = "TIMESTAMP")
	private Date createTime;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private Employee employee;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<Role> roles;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User{" + "userId=" + userId + ", login='" + login + '\'' + ", email='" + email + '\'' + ", password='"
				+ password + '\'' + ", createTime=" + createTime + ", employee=" + employee + ", role=" + roles + '}';
	}

	@Transient
	public Set<Permission> getPermissions() {
		Set<Permission> perms = new HashSet<Permission>();
		for (Role role : roles) {
			perms.addAll(role.getPermissions());
		}

		return perms;
	}

	@Override
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.addAll(getRoles());
		authorities.addAll(getPermissions());

		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// return true = account is valid / not expired
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// return true = account is not locked
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// return true = password is valid / not expired
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return login;
	}

}
