package com.sport.gestionmuscu.entity;
	
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
	

@Entity
public class SuperAdmin {

	    @Id
	    @GeneratedValue
	    private Long idSuperAdmin;
	    private String firstNameSuperAdmin;
	    private String lastNameSuperAdmin;
	    private String loginSuperAdmin;
	    private String passSuperAdmin;
	   

		public SuperAdmin() {
			super();
		}
		

		

		public SuperAdmin(String firstNameSuperAdmin, String lastNameSuperAdmin, String loginSuperAdmin,
				String passSuperAdmin) {
			super();
			this.firstNameSuperAdmin = firstNameSuperAdmin;
			this.lastNameSuperAdmin = lastNameSuperAdmin;
			this.loginSuperAdmin = loginSuperAdmin;
			this.passSuperAdmin = passSuperAdmin;
		}




		public SuperAdmin(Long idSuperAdmin, String firstNameSuperAdmin, String lastNameSuperAdmin,
				String loginSuperAdmin, String passSuperAdmin) {
			super();
			this.idSuperAdmin = idSuperAdmin;
			this.firstNameSuperAdmin = firstNameSuperAdmin;
			this.lastNameSuperAdmin = lastNameSuperAdmin;
			this.loginSuperAdmin = loginSuperAdmin;
			this.passSuperAdmin = passSuperAdmin;
		}

		public Long getIdSuperAdmin() {
			return idSuperAdmin;
		}

		public void setIdSuperAdmin(Long idSuperAdmin) {
			this.idSuperAdmin = idSuperAdmin;
		}

		public String getFirstNameSuperAdmin() {
			return firstNameSuperAdmin;
		}

		public void setFirstNameSuperAdmin(String firstNameSuperAdmin) {
			this.firstNameSuperAdmin = firstNameSuperAdmin;
		}

		public String getLastNameSuperAdmin() {
			return lastNameSuperAdmin;
		}



		public void setLastNameSuperAdmin(String lastNameSuperAdmin) {
			this.lastNameSuperAdmin = lastNameSuperAdmin;
		}



		public String getLoginSuperAdmin() {
			return loginSuperAdmin;
		}



		public void setLoginSuperAdmin(String loginSuperAdmin) {
			this.loginSuperAdmin = loginSuperAdmin;
		}



		public String getPassSuperAdmin() {
			return passSuperAdmin;
		}



		public void setPassSuperAdmin(String passSuperAdmin) {
			this.passSuperAdmin = passSuperAdmin;
		}




		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((firstNameSuperAdmin == null) ? 0 : firstNameSuperAdmin.hashCode());
			result = prime * result + ((idSuperAdmin == null) ? 0 : idSuperAdmin.hashCode());
			result = prime * result + ((lastNameSuperAdmin == null) ? 0 : lastNameSuperAdmin.hashCode());
			result = prime * result + ((loginSuperAdmin == null) ? 0 : loginSuperAdmin.hashCode());
			result = prime * result + ((passSuperAdmin == null) ? 0 : passSuperAdmin.hashCode());
			return result;
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SuperAdmin other = (SuperAdmin) obj;
			if (firstNameSuperAdmin == null) {
				if (other.firstNameSuperAdmin != null)
					return false;
			} else if (!firstNameSuperAdmin.equals(other.firstNameSuperAdmin))
				return false;
			if (idSuperAdmin == null) {
				if (other.idSuperAdmin != null)
					return false;
			} else if (!idSuperAdmin.equals(other.idSuperAdmin))
				return false;
			if (lastNameSuperAdmin == null) {
				if (other.lastNameSuperAdmin != null)
					return false;
			} else if (!lastNameSuperAdmin.equals(other.lastNameSuperAdmin))
				return false;
			if (loginSuperAdmin == null) {
				if (other.loginSuperAdmin != null)
					return false;
			} else if (!loginSuperAdmin.equals(other.loginSuperAdmin))
				return false;
			if (passSuperAdmin == null) {
				if (other.passSuperAdmin != null)
					return false;
			} else if (!passSuperAdmin.equals(other.passSuperAdmin))
				return false;
			return true;
		}



		@Override
		public String toString() {
			return "SuperAdmin [idSuperAdmin=" + idSuperAdmin + ", firstNameSuperAdmin=" + firstNameSuperAdmin
					+ ", lastNameSuperAdmin=" + lastNameSuperAdmin + ", loginSuperAdmin=" + loginSuperAdmin
					+ ", passSuperAdmin=" + passSuperAdmin + "]";
		}



		
}
