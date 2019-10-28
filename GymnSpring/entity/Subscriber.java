package com.sport.gestionmuscu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Subscriber {
	    @Id
	    @GeneratedValue
	    private Long idSub;
	    private String firstNameSub;
	    private String lastNameSub;
	    private Date dateSubscription;
	    private int ageSub;
	    private int weightSub;
	    private int heightSub;
	    // S M L XL XXL
	    private String sizeSub;
	    
	    @ManyToOne
	    @JoinColumn(name="club")
	    private Club club;
	    
	    @OneToOne
	    @JoinColumn(name="picture")
	    private Picture picture;
	    
	    @OneToMany(mappedBy = "subscriber")
	    private List<Presence> presence = new ArrayList<>();
	    
	    @OneToMany (mappedBy = "subscriber")
	    private List<Subscription> subscription=new ArrayList<>();

		public Subscriber() {
			super();
		}

		public Subscriber(String firstNameSub, String lastNameSub, Date dateSubscription, int ageSub,
				int weightSub, int heightSub, String sizeSub) {
			super();
			this.firstNameSub = firstNameSub;
			this.lastNameSub = lastNameSub;
			this.dateSubscription = dateSubscription;
			this.ageSub = ageSub;
			this.weightSub = weightSub;
			this.heightSub = heightSub;
			this.sizeSub = sizeSub;
		}

		@Override
		public String toString() {
			return "Subscriber [idSub=" + idSub + ", firstNameSub=" + firstNameSub + ", lastNameSub="
					+ lastNameSub + "]";
		}

		public Long getidSub() {
			return idSub;
		}

		public void setidSub(Long idSub) {
			this.idSub = idSub;
		}

		public String getfirstNameSub() {
			return firstNameSub;
		}

		public void setfirstNameSub(String firstNameSub) {
			this.firstNameSub = firstNameSub;
		}

		public String getlastNameSub() {
			return lastNameSub;
		}

		public void setlastNameSub(String lastNameSub) {
			this.lastNameSub = lastNameSub;
		}

		public Date getdateSubscription() {
			return dateSubscription;
		}

		public void setdateSubscription(Date dateSubscription) {
			this.dateSubscription = dateSubscription;
		}

		public int getageSub() {
			return ageSub;
		}

		public void setageSub(int ageSub) {
			this.ageSub = ageSub;
		}

		public int getweightSub() {
			return weightSub;
		}

		public void setweightSub(int weightSub) {
			this.weightSub = weightSub;
		}

		public int getheightSub() {
			return heightSub;
		}

		public void setheightSub(int heightSub) {
			this.heightSub = heightSub;
		}

		public String getsizeSub() {
			return sizeSub;
		}

		public void setsizeSub(String sizeSub) {
			this.sizeSub = sizeSub;
		}

		public Club getClub() {
			return club;
		}

		public void setClub(Club club) {
			this.club = club;
		}

		public Picture getPicture() {
			return picture;
		}

		public void setPicture(Picture picture) {
			this.picture = picture;
		}

		public List<Presence> getPresence() {
			return presence;
		}

		public void addPresence(Presence presence) {
			this.presence.add(presence);
		}

		public List<Subscription> getSubscription() {
			return subscription;
		}

		public void addSubscription(Subscription subscription) {
			this.subscription.add(subscription);
		}    
	    	    
		
	    
	}