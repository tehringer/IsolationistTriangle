package com.rev.barberharbor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BARBERS")
public class Barber extends User implements Serializable{

	private static final long serialVersionUID = 3561852746756800741L;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SHOPS_ID")
	private Shop shop;
	
	@Column(name="WEBSITE")
	private String website;

	public Barber() {
		super();
	}
	
	public Barber(String website) {
		super();
		this.website = website;
	}
	
	public Barber(Shop shop) {
		super();
		this.shop = shop;
	}

	public Barber(Long id, Shop shop, String website) {
		super();
		this.shop = shop;
		this.website = website;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Barber [shop=" + shop + ", website=" + website + "]";
	}
	
	

}
