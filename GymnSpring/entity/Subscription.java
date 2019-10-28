package com.sport.gestionmuscu.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subscription {
    @Id
    @GeneratedValue
    private Long idSubs;
    private Date datePaymentSubSubs;
    private String startDateValidSubSubs;
    private String endDateValidSubSubs;
    
    @ManyToOne
    @JoinColumn(name="logger")
    private AdminClub logger;
    
    @ManyToOne
    @JoinColumn(name="subscriber")
    private Subscriber subscriber;

    @ManyToOne
    @JoinColumn(name="subscription_type")
    private SubscriptionType subscriptionType;
    
	public Subscription() {
		super();
	}

	public Subscription(Date datePaymentSubSubs) {
		super();
		this.datePaymentSubSubs = datePaymentSubSubs;
	}

	@Override
	public String toString() {
		return "Subscription [idSubs=" + idSubs + ", datePaymentSubSubs=" + datePaymentSubSubs + "]";
	}

	public Long getidSubs() {
		return idSubs;
	}

	public void setidSubs(Long idSubs) {
		this.idSubs = idSubs;
	}

	public Date getdatePaymentSubSubs() {
		return datePaymentSubSubs;
	}

	public void setdatePaymentSubSubs(Date datePaymentSubSubs) {
		this.datePaymentSubSubs = datePaymentSubSubs;
	}

	public String getstartDateValidSubSubs() {
		return startDateValidSubSubs;
	}

	public void setstartDateValidSubSubs(String startDateValidSubSubs) {
		this.startDateValidSubSubs = startDateValidSubSubs;
	}

	public String getendDateValidSubSubs() {
		return endDateValidSubSubs;
	}

	public void setendDateValidSubSubs(String endDateValidSubSubs) {
		this.endDateValidSubSubs = endDateValidSubSubs;
	}

	public AdminClub getLogger() {
		return logger;
	}

	public void setLogger(AdminClub logger) {
		this.logger = logger;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
    
    
}
