package com.sport.gestionmuscu.entity;

import javax.persistence.Entity;

@Entity
public class PerDaySubscription extends SubscriptionType{

	private Long pricePerDaySubscription;
	
	protected PerDaySubscription() {}
	
	public PerDaySubscription(String name_type_subs, String desc_type_subs, Long pricePerDaySubscription) {
		super(name_type_subs,desc_type_subs);
		this.pricePerDaySubscription = pricePerDaySubscription;
	}

	@Override
	public String toString() {
		return "PerDaySubscription [pricePerDaySubscription=" + pricePerDaySubscription + ", toString()="
				+ super.toString() + "]";
	}

	public Long getpricePerDaySubscription() {
		return pricePerDaySubscription;
	}

	public void setpricePerDaySubscription(Long pricePerDaySubscription) {
		this.pricePerDaySubscription = pricePerDaySubscription;
	}
	
	

	
	
}
