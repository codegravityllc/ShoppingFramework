package com.hibernate.springdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UsersEntity {

	@Id
	@Column(name="userid")
	String uid;
	@Column(name="password")
	String pwd;	
	@Column(name="first_name")
	String firstName;
	@Column(name="last_name")
	String lastName;
	@Column(name="address")
	String address;
	public UsersEntity(String uid,String pwd )
	{
		this.uid=uid;
		this.pwd=pwd;
	}
	// uid is unqiue key in the table, need atleast a constructor with uid only.
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UsersEntity(String uid)
	{
		this.uid=uid;
	}
	public UsersEntity()
	{
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFirstName() {
		return firstName;
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

	public String toString()
	{
		return "User:"+uid+",Pwd:"+pwd ;
	}

}
