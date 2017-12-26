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
	
	@Id
	@Column(name="BARBERS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="BARBER_SEQ", sequenceName="BARBER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BARBER_SEQ")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SHOPS_ID")
	private Shop shop;
	
	@Column(name="WEBSITE")
	private String website;

}
