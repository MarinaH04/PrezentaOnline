package com.proiect.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "curs")
public class Curs implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "curs_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer curs_id;

	@Column(name = "denumire")
	private String denumire;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.cs")
	private Set<UserCurs> usercurs = new HashSet<UserCurs>();

	public Curs() {
	}

	public Curs(String denumire) {
		this.denumire = denumire;
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

	public Set<UserCurs> getUsercurs() {
		return usercurs;
	}


	public void setUsercurs(Set<UserCurs> usercurs) {
		this.usercurs = usercurs;
	}

	@Override
	public String toString() {
		return "Curs [curs_id=" + curs_id + ", denumire=" + denumire + ", usercurs=" + usercurs + "]";
	}

	
}
