package com.sport.gestionmuscu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long id_activity;
    private String name_activity;
    private String summary_activity;
    
    @ManyToMany(mappedBy="activity")
    private List<Club> clubs = new ArrayList<>();
    
	public Activity() {
		super();
	}

	public Activity(String name_activity, String summary_activity) {
		super();
		this.name_activity = name_activity;
		this.summary_activity = summary_activity;
	}

	@Override
	public String toString() {
		return "Activity [id_activity=" + id_activity + ", name_activity=" + name_activity + "]";
	}

	public Long getId_activity() {
		return id_activity;
	}

	public void setId_activity(Long id_activity) {
		this.id_activity = id_activity;
	}

	public String getName_activity() {
		return name_activity;
	}

	public void setName_activity(String name_activity) {
		this.name_activity = name_activity;
	}

	public String getSummary_activity() {
		return summary_activity;
	}

	public void setSummary_activity(String summary_activity) {
		this.summary_activity = summary_activity;
	}

	public List<Club> getClubs() {
		return clubs;
	}

	public void addClub(Club club) {
		this.clubs.add(club); 
	}
	
	public void removeClub(Club club) {
		this.clubs.remove(club); 
	}
	
	
    
}
