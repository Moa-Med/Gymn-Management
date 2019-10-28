package com.sport.gestionmuscu.entity;

import javax.persistence.Entity;

@Entity
public class PerThreeMonthSubscription extends SubscriptionType{
	
	private long pricePerThreeMonthSubscription;
	
	protected PerThreeMonthSubscription() {}
	
	public PerThreeMonthSubscription(String name_type_subs, String desc_type_subs, Long pricePerThreeMonthSubscription) {
		super(name_type_subs,desc_type_subs);
		this.pricePerThreeMonthSubscription = pricePerThreeMonthSubscription;
	}

	@Override
	public String toString() {
		return "PerThreeMonthSubscription [pricePerThreeMonthSubscription=" + pricePerThreeMonthSubscription
				+ ", toString()=" + super.toString() + "]";
	}

	public long getpricePerThreeMonthSubscription() {
		return pricePerThreeMonthSubscription;
	}

	public void setpricePerThreeMonthSubscription(long pricePerThreeMonthSubscription) {
		this.pricePerThreeMonthSubscription = pricePerThreeMonthSubscription;
	}
	
	
}
