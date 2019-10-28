package com.sport.gestionmuscu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypePayment {
    @Id
    @GeneratedValue
    private Long id_type_payment;
    private String type_of_payment;
    
    @OneToMany(mappedBy="type_payment")
    private List<InfoPaymentClub> infoPaymentClub = new ArrayList<>();

	public TypePayment() {
		super();
	}

	public TypePayment(String type_of_payment) {
		super();
		this.type_of_payment = type_of_payment;
	}

	@Override
	public String toString() {
		return "TypePayment [id_type_payment=" + id_type_payment + ", type_of_payment=" + type_of_payment + "]";
	}

	public Long getId_type_payment() {
		return id_type_payment;
	}

	public void setId_type_payment(Long id_type_payment) {
		this.id_type_payment = id_type_payment;
	}

	public String getType_of_payment() {
		return type_of_payment;
	}

	public void setType_of_payment(String type_of_payment) {
		this.type_of_payment = type_of_payment;
	}

	public List<InfoPaymentClub> getInfoPaymentClub() {
		return infoPaymentClub;
	}

	public void addInfoPaymentClub(InfoPaymentClub infoPaymentClub) {
		this.infoPaymentClub.add(infoPaymentClub);
	}
    
    
    
}
