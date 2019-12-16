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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;


@Entity
@Table(name = "curs")
public class Curs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer curs_id;

	@Column(name = "denumire")
	private String denumire;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, targetEntity = User.class)
	@JoinTable(name = "user_curs", joinColumns = {
			@JoinColumn(name = "user_id", insertable = true, updatable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "curs_id", insertable = true, updatable = true) })
	 @JsonBackReference
	private Set<User> user = new HashSet<User>();

	public Curs() {
	}

	public Curs(String denumire) {
		this.denumire = denumire;
	}

	public void add_user(User useri) {

		user.add(useri);
	}

	public Integer getCurs_id() {
		return curs_id;
	}

	public void setCurs_id(Integer curs_id) {
		this.curs_id = curs_id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Curs [curs_id=" + curs_id + ", denumire=" + denumire + ", user=" + user.size() + "]";
	}

}
