package com.sport.gestionmuscu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class InfoPaymentClub {
    @Id
    @GeneratedValue
    private Long id_info_payment_club; 
    private String ref_credit_card;
    private Date date_validity;
    private Long code_credit_card;
    private boolean active;
    
    @ManyToOne
    @JoinColumn(name="club")
    private Club club;
    
    @ManyToOne
    @JoinColumn(name="type_of_payment")
    private TypePayment type_payment;
    
    @OneToMany(mappedBy = "info_payment_used")
    private List<ClubSubscription> clubSubscription = new ArrayList<>();

	public InfoPaymentClub() {
		super();
	}

	public InfoPaymentClub(String ref_credit_card, Date date_validity, Long code_credit_card) {
		super();
		this.ref_credit_card = ref_credit_card;
		this.date_validity = date_validity;
		this.code_credit_card = code_credit_card;
	}

	@Override
	public String toString() {
		return "InfoPaymentClub [id_info_payment_club=" + id_info_payment_club + ", ref_credit_card=" + ref_credit_card
				+ "]";
	}

	public Long getId_info_payment_club() {
		return id_info_payment_club;
	}

	public void setId_info_payment_club(Long id_info_payment_club) {
		this.id_info_payment_club = id_info_payment_club;
	}

	public String getRef_credit_card() {
		return ref_credit_card;
	}

	public void setRef_credit_card(String ref_credit_card) {
		this.ref_credit_card = ref_credit_card;
	}

	public Date getDate_validity() {
		return date_validity;
	}

	public void setDate_validity(Date date_validity) {
		this.date_validity = date_validity;
	}

	public Long getCode_credit_card() {
		return code_credit_card;
	}

	public void setCode_credit_card(Long code_credit_card) {
		this.code_credit_card = code_credit_card;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Club getClub() {
		return club;
	}

	public void addClub(Club club) {
		this.club = club;
	}

	public TypePayment getType_payment() {
		return type_payment;
	}

	public void setType_payment(TypePayment type_payment) {
		this.type_payment = type_payment;
	}

	public List<ClubSubscription> getClubSubscription() {
		return clubSubscription;
	}

	public void setClubSubscription(List<ClubSubscription> clubSubscription) {
		this.clubSubscription = clubSubscription;
	}
    
    
}
