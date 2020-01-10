package com.proiect.persistence.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embeddable;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Embeddable
public class UserCursID implements java.io.Serializable {

	private static final long serialVersionUID = -9120607274421816301L;
	
	
	private User user;
	private Curs cs;
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	public Curs getCs() {
		return cs;
	}
	public void setCs(Curs cs) {
		this.cs = cs;
	}
	
	@Override
    public int hashCode() {
         int result;
            result = (user != null ? user.hashCode() : 0);
            result = 17 * result + (cs != null ? cs.hashCode() : 0);
            return result;
    }
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof UserCursID))
	            return false;
	        UserCursID other = (UserCursID) obj;
	        if (cs == null) {
	            if (other.cs != null)
	                return false;
	        } else if (!cs.equals(other.cs))
	            return false;
	        if (user == null) {
	            if (other.user != null)
	                return false;
	        } else if (!user.equals(other.user))
	            return false;
	        return true;
	    }
}
