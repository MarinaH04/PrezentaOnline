package com.proiect.persistence.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_curs")
public class UserCurs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uc_id")
	private Integer uc_id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="curs_id")
	private Curs curs;

	public Integer getUc_id() {
		return uc_id;
	}

	public void setUc_id(Integer uc_id) {
		this.uc_id = uc_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Curs getCurs() {
		return curs;
	}

	public void setCurs(Curs curs) {
		this.curs = curs;
	}
	

}
