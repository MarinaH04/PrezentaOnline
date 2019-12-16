package com.proiect.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;




@Entity
@Table(name="user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer user_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="id")
	private UserType userType;
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, targetEntity = Curs.class)
	@JoinTable(name = "user_curs", joinColumns = { 
			@JoinColumn(name = "user_id", insertable=true, updatable=true) }, 
			inverseJoinColumns = { @JoinColumn(name = "curs_id", insertable=true, updatable=true) })
	@JsonManagedReference
	private Set<Curs> curs = new HashSet<Curs>(); 
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Set<Curs> getCurs() {
		return curs;
	}

	public void setCurs(Set<Curs> curs) {
		this.curs = curs;
	}
	public User() {}
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public void add_curs(Curs cursuri) {
		curs.add(cursuri);
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", user_type=" + userType + ", curs=" + curs.size() + "]";
	}
	
	
}
