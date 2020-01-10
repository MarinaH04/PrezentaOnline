package com.proiect.persistence.entity;

//import java.beans.Transient;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_curs")
@AssociationOverrides({
	@AssociationOverride(name="pk.user", joinColumns = @JoinColumn(name="id_user")),
	@AssociationOverride(name="pk.cs", joinColumns = @JoinColumn(name="id_curs"))
})
public class UserCurs implements java.io.Serializable {

	private static final long serialVersionUID = 4050660680047579957L;
	
	private UserCursID pk = new UserCursID();
	
	@Id
	@Column(name="uc_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uc_id;
	
	
//	@Transient
//	public User getUser() {
//		return getPk().getUser();
//	}
//	
//	public void setUser(User user) {
//		getPk().setUser(user);
//	}
//	
//	@Transient
//	public Curs getCs() {
//		return getPk().getCs();
//	}
//	
//	
//	public void setCs(Curs c) {
//		getPk().setCs(c);
//	}
	
	public Integer getUc_id() {
		return uc_id;
	}

	public void setUc_id(Integer uc_id) {
		this.uc_id = uc_id;
	}
	
	@EmbeddedId
	public UserCursID getPk() {
		return pk;
	}
	public void setPk(UserCursID pk) {
		this.pk = pk;
	}

}
