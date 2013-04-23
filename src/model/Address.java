package model;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 6780532528672421304L;
	
	// member fields for the address
	private String name;
	private String emailaddress;

	public Address() {
		System.out.println("constructing Address");
		init();
	}
	
	// initializing the values
	private void init() {
		System.out.println("initializing Address");
		this.name = "";
		this.emailaddress = "";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getEmailaddress() {
		return emailaddress;
	}
	
	// overriding the toString()-method
	public String toString() {
		return name + " " + emailaddress;
	}
}
