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
@Table(name="OrarCurs")
public class OrarCurs {
	@Id
	@Column(name="oc_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer oc_id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="curs_id")
	private Curs orarcurs;
	
	@Column(name="data_curs")
	private Date dataCurs;

	public Integer getOc_id() {
		return oc_id;
	}

	public void setOc_id(Integer oc_id) {
		this.oc_id = oc_id;
	}

	public Curs getOrarcurs() {
		return orarcurs;
	}

	public void setOrarcurs(Curs orarcurs) {
		this.orarcurs = orarcurs;
	}

	public Date getDataCurs() {
		return dataCurs;
	}

	public void setDataCurs(Date dataCurs) {
		this.dataCurs = dataCurs;
	}

	@Override
	public String toString() {
		return "OrarCurs [oc_id=" + oc_id + ", orarcurs=" + orarcurs + ", dataCurs=" + dataCurs + "]";
	}

	
}
