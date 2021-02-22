package com.HibernateMap.model;

import javax.persistence.*;

@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column
	private String acc_Number;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAcc_Number() {
		return acc_Number;
	}

	public void setAcc_Number(String acc_Number) {
		this.acc_Number = acc_Number;
	}
	


}
