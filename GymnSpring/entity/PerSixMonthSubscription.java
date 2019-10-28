package com.sport.gestionmuscu.entity;

import javax.persistence.Entity;

@Entity
public class PerSixMonthSubscription extends SubscriptionType{
	
	private long pricePerSixMonthSubscription;

	public PerSixMonthSubscription() {
		super();
	}

	public PerSixMonthSubscription(String nameTypeSubs, String descTypeSubs, Long pricePerSixMonthSubscription) {
		super(nameTypeSubs, descTypeSubs);
		this.pricePerSixMonthSubscription=pricePerSixMonthSubscription;
		// TODO Auto-generated constructor stub
	}

	public long getPricePerSixMonthSubscription() {
		return pricePerSixMonthSubscription;
	}

	public void setPricePerSixMonthSubscription(long pricePerSixMonthSubscription) {
		this.pricePerSixMonthSubscription = pricePerSixMonthSubscription;
	}
	
	
}
