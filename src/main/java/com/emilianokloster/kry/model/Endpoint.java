package com.emilianokloster.kry.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/*
 * JPA entity. It handles DDL sql sentences automatically. 
 */

@Entity
public class Endpoint {
	
	@Id
	@GeneratedValue
	private Long id;

    @Transient
    private String status;
	
	private String url;
    private String name;
    private String userInsert;
    private LocalDate dateInsert;
    private LocalDate dateLastUpdate;
    private String comment;
    
    public Endpoint() {}
    
	public Endpoint(Long id, String url, String name, String status) {
		this.id = id;
		this.url = url;
		this.name = name;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserInsert() {
		return userInsert;
	}

	public void setUserInsert(String userInsert) {
		this.userInsert = userInsert;
	}

	public LocalDate getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(LocalDate dateInsert) {
		this.dateInsert = dateInsert;
	}

	public LocalDate getDateLastUpdate() {
		return dateLastUpdate;
	}

	public void setDateLastUpdate(LocalDate dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
}
