package com.proiect.persistence.entity;


import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PrezentaID implements java.io.Serializable{

	private static final long serialVersionUID = -9120607274421816301L;
	
	private UserCurs usercurs;
	private OrarCurs orar;
	
	@ManyToOne
	public UserCurs getUserCurs() {
		return usercurs;
	}
	public void setUserCurs(UserCurs usercurs) {
		this.usercurs = usercurs;
	}
	
	@ManyToOne
	public OrarCurs getOrar() {
		return orar;
	}
	public void setOrar(OrarCurs orar) {
		this.orar = orar;
	}
	
	@Override
    public int hashCode() {
         int result;
            result = (usercurs != null ? usercurs.hashCode() : 0);
            result = 17 * result + (orar != null ? orar.hashCode() : 0);
            return result;
    }
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof PrezentaID))
	            return false;
	        PrezentaID other = (PrezentaID) obj;
	        if (orar == null) {
	            if (other.orar != null)
	                return false;
	        } else if (!orar.equals(other.orar))
	            return false;
	        if (usercurs == null) {
	            if (other.usercurs != null)
	                return false;
	        } else if (!usercurs.equals(other.usercurs))
	            return false;
	        return true;
	    }
}
