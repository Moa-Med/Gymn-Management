package com.sport.gestionmuscu.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Presence {
    @Id
    @GeneratedValue
    private Long id_presence;
    private Date date_presence;
    private String note;
    
    @ManyToOne
    @JoinColumn(name="subscriber")
    private Subscriber subscriber;

	public Presence() {
		super();
	}

	public Presence(Date date_presence, String note) {
		super();
		this.date_presence = date_presence;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Presence [id_presence=" + id_presence + ", date_presence=" + date_presence + "]";
	}

	public Long getId_presence() {
		return id_presence;
	}

	public void setId_presence(Long id_presence) {
		this.id_presence = id_presence;
	}

	public Date getDate_presence() {
		return date_presence;
	}

	public void setDate_presence(Date date_presence) {
		this.date_presence = date_presence;
	}

	public String getnote() {
		return note;
	}

	public void setnote(String note) {
		this.note = note;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
    
	
    
}
