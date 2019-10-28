package com.sport.gestionmuscu.entity;

import javax.persistence.Entity;

@Entity
public class PerYearSubscription extends SubscriptionType{

	private Long pricePerYearSubscription;
	
	protected PerYearSubscription() {}
	
	public PerYearSubscription(String name_type_subs, String desc_type_subs, Long pricePerYearSubscription) {
		super(name_type_subs,desc_type_subs);
		this.pricePerYearSubscription = pricePerYearSubscription;
	}

	@Override
	public String toString() {
		return "PerYearSubscription [pricePerYearSubscription=" + pricePerYearSubscription + ", toString()="
				+ super.toString() + "]";
	}

	public Long getpricePerYearSubscription() {
		return pricePerYearSubscription;
	}

	public void setpricePerYearSubscription(Long pricePerYearSubscription) {
		this.pricePerYearSubscription = pricePerYearSubscription;
	}
	
	
}
