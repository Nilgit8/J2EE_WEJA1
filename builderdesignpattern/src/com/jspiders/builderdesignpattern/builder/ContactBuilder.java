package com.jspiders.builderdesignpattern.builder;

public class ContactBuilder {
	private String first_name;
	private String middle_name;
	private String last_name;
	private String email;
	private long mobile_no;
	private long landline_no;
	private String gender;
	private String address;
	private String company;
	private String dob;
	public ContactBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactBuilder(String first_name, String middle_name, String last_name, String email, long mobile_no,
			long landline_no, String gender, String address, String company, String dob) {
		super();
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.mobile_no = mobile_no;
		this.landline_no = landline_no;
		this.gender = gender;
		this.address = address;
		this.company = company;
		this.dob = dob;
	}
	public ContactBuilder setFirst_name(String first_name) {
		this.first_name = first_name;
		return this;
	}
	public ContactBuilder setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
		return this;
	}
	public ContactBuilder setLast_name(String last_name) {
		this.last_name = last_name;
		return this;
	}
	public ContactBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	public ContactBuilder setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
		return this;
	}
	public ContactBuilder setLandline_no(long landline_no) {
		this.landline_no = landline_no;
		return this;
	}
	public ContactBuilder setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public ContactBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	public ContactBuilder setCompany(String company) {
		this.company = company;
		return this;
	}
	public ContactBuilder setDob(String dob) {
		this.dob = dob;
		return this;
	}
	
	
	
}
