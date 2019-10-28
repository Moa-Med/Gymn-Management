package com.sport.gestionmuscu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AdminClub {
    @Id
    @GeneratedValue
    private Long idAdminClub;
    private String firstNameAdminClub;
    private String lastNameAdminClub;
    private String email;
    private String numIdentite;
    private Date dateInscription;
    private String loginAdminClub;
    private String passAdminClub;
    
    @ManyToOne
    @JoinColumn(name="club")
    private Club club;
    
    @OneToMany(mappedBy = "logger")    
    private List<Subscription> saved_subscriptions = new ArrayList<>();

	public AdminClub() {
		super();
	}

	public Long getIdAdminClub() {
		return idAdminClub;
	}

	public void setIdAdminClub(Long idAdminClub) {
		this.idAdminClub = idAdminClub;
	}

	public String getFirstNameAdminClub() {
		return firstNameAdminClub;
	}

	public void setFirstNameAdminClub(String firstNameAdminClub) {
		this.firstNameAdminClub = firstNameAdminClub;
	}

	public String getLastNameAdminClub() {
		return lastNameAdminClub;
	}

	public void setLastNameAdminClub(String lastNameAdminClub) {
		this.lastNameAdminClub = lastNameAdminClub;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getNumIdentite() {
		return numIdentite;
	}

	public void setNumIdentite(String numIdentite) {
		this.numIdentite = numIdentite;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getLoginAdminClub() {
		return loginAdminClub;
	}

	public void setLoginAdminClub(String loginAdminClub) {
		this.loginAdminClub = loginAdminClub;
	}

	public String getPassAdminClub() {
		return passAdminClub;
	}

	public void setPassAdminClub(String passAdminClub) {
		this.passAdminClub = passAdminClub;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public List<Subscription> getSaved_subscriptions() {
		return saved_subscriptions;
	}
	public void addSubscription(Subscription subscription) {
		this.saved_subscriptions.add(subscription);
	}/*

	public void setSaved_subscriptions(List<Subscription> saved_subscriptions) {
		this.saved_subscriptions = saved_subscriptions;
	}
*/
	public AdminClub(String firstNameAdminClub, String lastNameAdminClub, String email, String numIdentite,
			Date dateInscription, String loginAdminClub, String passAdminClub
			) {
		super();
		this.firstNameAdminClub = firstNameAdminClub;
		this.lastNameAdminClub = lastNameAdminClub;
		this.email = email;
		this.numIdentite = numIdentite;
		this.dateInscription = dateInscription;
		this.loginAdminClub = loginAdminClub;
		this.passAdminClub = passAdminClub;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((club == null) ? 0 : club.hashCode());
		result = prime * result + ((dateInscription == null) ? 0 : dateInscription.hashCode());
		result = prime * result + ((firstNameAdminClub == null) ? 0 : firstNameAdminClub.hashCode());
		result = prime * result + ((idAdminClub == null) ? 0 : idAdminClub.hashCode());
		result = prime * result + ((lastNameAdminClub == null) ? 0 : lastNameAdminClub.hashCode());
		result = prime * result + ((loginAdminClub == null) ? 0 : loginAdminClub.hashCode());
		result = prime * result + ((numIdentite == null) ? 0 : numIdentite.hashCode());
		result = prime * result + ((passAdminClub == null) ? 0 : passAdminClub.hashCode());
		result = prime * result + ((saved_subscriptions == null) ? 0 : saved_subscriptions.hashCode());
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
		AdminClub other = (AdminClub) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (club == null) {
			if (other.club != null)
				return false;
		} else if (!club.equals(other.club))
			return false;
		if (dateInscription == null) {
			if (other.dateInscription != null)
				return false;
		} else if (!dateInscription.equals(other.dateInscription))
			return false;
		if (firstNameAdminClub == null) {
			if (other.firstNameAdminClub != null)
				return false;
		} else if (!firstNameAdminClub.equals(other.firstNameAdminClub))
			return false;
		if (idAdminClub == null) {
			if (other.idAdminClub != null)
				return false;
		} else if (!idAdminClub.equals(other.idAdminClub))
			return false;
		if (lastNameAdminClub == null) {
			if (other.lastNameAdminClub != null)
				return false;
		} else if (!lastNameAdminClub.equals(other.lastNameAdminClub))
			return false;
		if (loginAdminClub == null) {
			if (other.loginAdminClub != null)
				return false;
		} else if (!loginAdminClub.equals(other.loginAdminClub))
			return false;
		if (numIdentite == null) {
			if (other.numIdentite != null)
				return false;
		} else if (!numIdentite.equals(other.numIdentite))
			return false;
		if (passAdminClub == null) {
			if (other.passAdminClub != null)
				return false;
		} else if (!passAdminClub.equals(other.passAdminClub))
			return false;
		if (saved_subscriptions == null) {
			if (other.saved_subscriptions != null)
				return false;
		} else if (!saved_subscriptions.equals(other.saved_subscriptions))
			return false;
		return true;
	}


	}
