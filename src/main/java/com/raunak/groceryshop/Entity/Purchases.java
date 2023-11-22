package com.raunak.groceryshop.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchases {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;

	@Column(name = "purchase_user", nullable = false, length = 20)
	private Integer purchseUser ;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPurchseUser() {
		return purchseUser;
	}

	public void setPurchseUser(Integer purchseUser) {
		this.purchseUser = purchseUser;
	}
}
