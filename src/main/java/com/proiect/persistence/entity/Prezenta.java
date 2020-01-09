package com.proiect.persistence.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="prezenta")
@AssociationOverrides({
	@AssociationOverride(name="pk1.usercurs", joinColumns = @JoinColumn(name="id_usercurs", referencedColumnName="usercurs_id")),
	@AssociationOverride(name="pk1.orar", joinColumns = @JoinColumn(name="id_orar", referencedColumnName="oc_id"))
})
public class Prezenta implements java.io.Serializable{

	private static final long serialVersionUID = 4050660680047579957L;
	
	private PrezentaID pk1 = new PrezentaID();
	private Boolean Present;
	
	@EmbeddedId
	public PrezentaID getPk1() {
		return pk1;
	}

	public Boolean getPresent() {
		return Present;
	}

	public void setPresent(Boolean present) {
		Present = present;
	}

	public void setPk1(PrezentaID pk1) {
		this.pk1 = pk1;
	}
	
	
}
