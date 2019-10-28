package com.sport.gestionmuscu.entity;

import javax.persistence.Entity;

@Entity
public class PerMonthSubscription extends SubscriptionType{
	
	private Long pricePerMonthSubscription;
	
	protected PerMonthSubscription() {}
	
	public PerMonthSubscription(String name_type_subs, String desc_type_subs, Long pricePerMonthSubscription) {
		super(name_type_subs,desc_type_subs);
		this.pricePerMonthSubscription = pricePerMonthSubscription;
	}

	@Override
	public String toString() {
		return "PerMonthSubscription [pricePerMonthSubscription=" + pricePerMonthSubscription + ", toString()="
				+ super.toString() + "]";
	}

	public Long getpricePerMonthSubscription() {
		return pricePerMonthSubscription;
	}

	public void setpricePerMonthSubscription(Long pricePerMonthSubscription) {
		this.pricePerMonthSubscription = pricePerMonthSubscription;
	}
	
	
}
