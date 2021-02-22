package com.HibernateMap.model;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//One to One Mapping
@Entity
@Table
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	@Email(message = "{user.email.invalid}")
    @NotEmpty(message = "Please enter email")
	private String emailId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "Employee_Account" , joinColumns = @JoinColumn(name = "Employee_Id") ,
	inverseJoinColumns = @JoinColumn(name = "Account_Id"))
	private Account account;

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	

}
