package com.sport.gestionmuscu.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ClubSubscription {
    @Id
    @GeneratedValue
    private Long id_club_subs;
    private Date date_payment_club_subs;
    private Date date_start_val_club_sub;
    private Date date_end_val_club_subs;
    private String note;
    
    @ManyToOne
    @JoinColumn(name="club")
    private Club club;
    
    @ManyToOne
    @JoinColumn(name="info_payment_used")
    private InfoPaymentClub info_payment_used;

	public ClubSubscription() {
		super();
	}

	public ClubSubscription(Date date_payment_club_subs, Date date_start_val_club_sub, Date date_end_val_club_subs,
			String note) {
		super();
		this.date_payment_club_subs = date_payment_club_subs;
		this.date_start_val_club_sub = date_start_val_club_sub;
		this.date_end_val_club_subs = date_end_val_club_subs;
		this.note = note;
	}

	@Override
	public String toString() {
		return "ClubSubscription [id_club_subs=" + id_club_subs + ", date_payment_club_subs=" + date_payment_club_subs
				+ "]";
	}

	public Long getId_club_subs() {
		return id_club_subs;
	}

	public void setId_club_subs(Long id_club_subs) {
		this.id_club_subs = id_club_subs;
	}

	public Date getDate_payment_club_subs() {
		return date_payment_club_subs;
	}

	public void setDate_payment_club_subs(Date date_payment_club_subs) {
		this.date_payment_club_subs = date_payment_club_subs;
	}

	public Date getDate_start_val_club_sub() {
		return date_start_val_club_sub;
	}

	public void setDate_start_val_club_sub(Date date_start_val_club_sub) {
		this.date_start_val_club_sub = date_start_val_club_sub;
	}

	public Date getDate_end_val_club_subs() {
		return date_end_val_club_subs;
	}

	public void setDate_end_val_club_subs(Date date_end_val_club_subs) {
		this.date_end_val_club_subs = date_end_val_club_subs;
	}

	public String getnote() {
		return note;
	}

	public void setnote(String note) {
		this.note = note;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public InfoPaymentClub getInfo_payment_used() {
		return info_payment_used;
	}

	public void setInfo_payment_used(InfoPaymentClub info_payment_used) {
		this.info_payment_used = info_payment_used;
	}
    
    

}
