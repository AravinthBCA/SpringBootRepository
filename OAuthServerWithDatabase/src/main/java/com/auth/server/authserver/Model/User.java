package com.auth.server.authserver.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Table(name="user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="enabled")
	private boolean enabled;
	@Column(name="accountNonExpired")
	private boolean accountNonExpired;
	@Column(name="credentialsNonExpired")
	private boolean credentialsNonExpired;
	@Column(name="accountNonLocked")
	private boolean accountNonLocked;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="role_user",joinColumns= {@JoinColumn(name="user_id",
			referencedColumnName="id")},inverseJoinColumns = {@JoinColumn(name="role_id")})
	private List<Role> roles;
	
	public User() {
    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountNonExpired = user.isAccountNonExpired();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.roles = user.getRoles();
    }

}
