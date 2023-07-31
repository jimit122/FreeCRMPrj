package org.qa.data;

import javax.annotation.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserTestData {

	@SerializedName("username")
	@Expose
	private String username;
	@SerializedName("password")
	@Expose
	private String password;
	@SerializedName("firstname")
	@Expose
	private String firstname;
	@SerializedName("lastname")
	@Expose
	private String lastname;
	@SerializedName("address")
	@Expose
	private Address address;
	@SerializedName("phonenumber")
	@Expose
	private String phonenumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public class Address {

		@SerializedName("addr1")
		@Expose
		private String addr1;
		@SerializedName("addr2")
		@Expose
		private String addr2;
		@SerializedName("city")
		@Expose
		private String city;
		@SerializedName("state")
		@Expose
		private String state;
		@SerializedName("zipcode")
		@Expose
		private String zipcode;

		public String getAddr1() {
			return addr1;
		}

		public void setAddr1(String addr1) {
			this.addr1 = addr1;
		}

		public String getAddr2() {
			return addr2;
		}

		public void setAddr2(String addr2) {
			this.addr2 = addr2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZipcode() {
			return zipcode;
		}

		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

	}

}