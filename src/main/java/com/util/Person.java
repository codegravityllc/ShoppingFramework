package com.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	@XmlElement
	public String name;
	@XmlElement
	public String password;
	@XmlAttribute
	public int age;
	@XmlElement
	public Addresses addresses;
	
	public Addresses getAddresses() {
		return addresses;
	}
	public void setAddresses(Addresses address) {
		this.addresses = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return "name:"+name+",password:"+password+",age:"+age;
	}
}
