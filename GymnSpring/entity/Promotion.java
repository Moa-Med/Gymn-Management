package com.sport.gestionmuscu.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Promotion extends SubscriptionType{

	private int nbMonth;
	private Long pricePromotion;
	private Date dateStartPromotion;
	private Date dateEndPromotion;
	
	protected Promotion() {}
	
	public Promotion(String name_type_subs, String desc_type_subs, int nbMonth, Long pricePromotion, Date dateStartPromotion, Date dateEndPromotion) {
		super(name_type_subs,desc_type_subs);
		this.pricePromotion = pricePromotion;
		this.nbMonth = nbMonth;
		this.dateStartPromotion=dateStartPromotion;
		this.dateEndPromotion=dateEndPromotion;
	}

	@Override
	public String toString() {
		return "Promotion [nbMonth=" + nbMonth + ", pricePromotion=" + pricePromotion + ", toString()="
				+ super.toString() + "]";
	}

	public int getnbMonth() {
		return nbMonth;
	}

	public void setnbMonth(int nbMonth) {
		this.nbMonth = nbMonth;
	}

	public Long getpricePromotion() {
		return pricePromotion;
	}

	public void setpricePromotion(Long pricePromotion) {
		this.pricePromotion = pricePromotion;
	}

	public Date getdateStartPromotion() {
		return dateStartPromotion;
	}

	public void setdateStartPromotion(Date dateStartPromotion) {
		this.dateStartPromotion = dateStartPromotion;
	}

	public Date getdateEndPromotion() {
		return dateEndPromotion;
	}

	public void setdateEndPromotion(Date dateEndPromotion) {
		this.dateEndPromotion = dateEndPromotion;
	}
	
	
	
}
