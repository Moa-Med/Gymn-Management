package com.sport.gestionmuscu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
public class Club {
    @Id
    @GeneratedValue
    private Long idClub;
    private String refClub;
    private String nameClub;
    private String addressClub;
    private String sumaryClub;
    
    @JsonIgnore
    @ManyToMany 
    @JoinTable(name="CLUB_ACTIVITY",joinColumns=@JoinColumn(name="idClub"),
    inverseJoinColumns=@JoinColumn(name="id_activity"))
    private List<Activity> activity = new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy="club")
    private List<InfoPaymentClub> infoPaymentClubs = new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy="club")
    private List<AdminClub> adminClub= new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<Subscriber> subscribers= new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<ClubSubscription> clubSubscription= new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<SubscriptionType> subscriptionType= new ArrayList<>();

	public Club() {
		super();
	}

	public Club(String refClub, String nameClub, String addressClub, String sumaryClub) {
		super();
		this.refClub = refClub;
		this.nameClub = nameClub;
		this.addressClub = addressClub;
		sumaryClub = sumaryClub;
	}

	@Override
	public String toString() {
		return "Club [idClub=" + idClub + ", refClub=" + refClub + ", nameClub=" + nameClub + "]";
	}

	public Long getidClub() {
		return idClub;
	}

	public void setidClub(Long idClub) {
		this.idClub = idClub;
	}

	public String getrefClub() {
		return refClub;
	}

	public void setrefClub(String refClub) {
		this.refClub = refClub;
	}

	public String getnameClub() {
		return nameClub;
	}

	public void setnameClub(String nameClub) {
		this.nameClub = nameClub;
	}

	public String getaddressClub() {
		return addressClub;
	}

	public void setaddressClub(String addressClub) {
		this.addressClub = addressClub;
	}

	public String getsumaryClub() {
		return sumaryClub;
	}

	public void setsumaryClub(String sumaryClub) {
		sumaryClub = sumaryClub;
	}

	public List<Activity> getActivity() {
		return activity;
	}

	public void addActivity(Activity activity) {
		this.activity.add(activity);
	}
	
	public void removeActivity(Activity activity) {
		this.activity.remove(activity);
	}

	public List<InfoPaymentClub> getinfoPaymentClubs() {
		return infoPaymentClubs;
	}

	public void addinfoPaymentClubs(InfoPaymentClub infoPayment_Club) {
		this.infoPaymentClubs.add(infoPayment_Club);
	}

	public List<AdminClub> getadminClub() {
		return adminClub;
	}

	public void addadminClub(AdminClub adminClub) {
		this.adminClub.add(adminClub);
	}
	
	public void setAdminClub(List<AdminClub> adminClub) {
		this.adminClub = adminClub;
	}

	public List<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void addSubscribers(Subscriber subscriber) {
		this.subscribers.add(subscriber);
	}
	
	public void removeSubscribers(Subscriber subscriber) {
		this.subscribers.remove(subscriber);
	}

	public List<ClubSubscription> getclubSubscription() {
		return clubSubscription;
	}

	public void addclubSubscription(ClubSubscription clubSubscription) {
		this.clubSubscription.add(clubSubscription);
	}

	public List<SubscriptionType> getsubscriptionType() {
		return subscriptionType;
	}

	public void addsubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType.add(subscriptionType);
	}

	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}

	public void setInfoPaymentClubs(List<InfoPaymentClub> infoPaymentClubs) {
		this.infoPaymentClubs = infoPaymentClubs;
	}

	public void setSubscribers(List<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

	public void setClubSubscription(List<ClubSubscription> clubSubscription) {
		this.clubSubscription = clubSubscription;
	}

	public void setSubscriptionType(List<SubscriptionType> subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
    
	
    
}
