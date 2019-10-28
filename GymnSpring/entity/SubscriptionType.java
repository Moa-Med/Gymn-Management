package com.sport.gestionmuscu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@Entity

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="subscription_type")
public abstract class SubscriptionType {
    @Id
    @GeneratedValue
    private Long idTypeSubs;
    private String nameTypeSubs;
    private String descTypeSubs;
    
    @ManyToOne
    @JoinColumn(name="club")
    private Club club;
    
    @OneToMany(mappedBy = "subscriptionType")
    private List<Subscription> subscription = new ArrayList<>();

    
	public SubscriptionType() {
		super();
	}


	public SubscriptionType(String nameTypeSubs, String descTypeSubs) {
		super();
		this.nameTypeSubs = nameTypeSubs;
		this.descTypeSubs = descTypeSubs;
	}


	@Override
	public String toString() {
		return "SubscriptionType [idTypeSubs=" + idTypeSubs + ", nameTypeSubs=" + nameTypeSubs + "]";
	}


	public Long getidTypeSubs() {
		return idTypeSubs;
	}


	public void setidTypeSubs(Long idTypeSubs) {
		this.idTypeSubs = idTypeSubs;
	}


	public String getnameTypeSubs() {
		return nameTypeSubs;
	}


	public void setnameTypeSubs(String nameTypeSubs) {
		this.nameTypeSubs = nameTypeSubs;
	}


	public String getdescTypeSubs() {
		return descTypeSubs;
	}


	public void setdescTypeSubs(String descTypeSubs) {
		this.descTypeSubs = descTypeSubs;
	}


	public Club getClub() {
		return club;
	}


	public void setClub(Club club) {
		this.club = club;
	}


	public List<Subscription> getSubscription() {
		return subscription;
	}

	public void addSubscription(Subscription subscription) {
		this.subscription.add(subscription);
	}   
    
    
}
