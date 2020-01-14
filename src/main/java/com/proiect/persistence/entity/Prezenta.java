package com.proiect.persistence.entity;

import java.util.Date;

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
@Table(name="prezenta")
public class Prezenta{
	
	@Id
	@Column(name = "id_prezenta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_prezenta;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="uc_id")
	private UserCurs usercurs;
	
	private Date date;
	
	private Boolean Present;
	
	
	public Integer getId_prezenta() {
		return id_prezenta;
	}

	public void setId_prezenta(Integer id_prezenta) {
		this.id_prezenta = id_prezenta;
	}

	public UserCurs getUsercurs() {
		return usercurs;
	}

	public void setUsercurs(UserCurs usercurs) {
		this.usercurs = usercurs;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getPresent() {
		return Present;
	}

	public void setPresent(Boolean present) {
		Present = present;
	}	
	
}
