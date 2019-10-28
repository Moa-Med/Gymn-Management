package com.sport.gestionmuscu.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Picture {
    @Id
    @GeneratedValue
    private Long id_picture;
    private String location_picture;
    
    @OneToOne(fetch = FetchType.LAZY,mappedBy="picture")
    private Subscriber subscriber;

	public Picture() {
		super();
	}

	public Picture(String location_picture) {
		super();
		this.location_picture = location_picture;
	}

	@Override
	public String toString() {
		return "Picture [id_picture=" + id_picture + ", location_picture=" + location_picture + "]";
	}

	public Long getId_picture() {
		return id_picture;
	}

	public void setId_picture(Long id_picture) {
		this.id_picture = id_picture;
	}

	public String getLocation_picture() {
		return location_picture;
	}

	public void setLocation_picture(String location_picture) {
		this.location_picture = location_picture;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
    
		
    
}
