package com.strut;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.hibernate.springdata.UsersEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.spring.beans.ProfileBean;

public class ProfileAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;

	public String testing1() {
		System.out.println("testing 1 method");
		return "success";
	}
	public String testing2() {
		System.out.println("testing 2 method");
		return "success";
	}
	// UI FORM DATA
	public String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String pwd;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	// UI FORM DATA

	@Autowired
	ProfileBean pb;

	// STRUTS BUSINESS METHOD
	public String execute() throws Exception {
		UsersEntity ue = pb.getProfile(userid);
		if (ue != null && ue.getPwd().equals(pwd)) {
			firstName = ue.getFirstName();
			lastName = ue.getLastName();
			return "success";
		} else
			return "error";
	}

	public String jsonResponse() throws Exception {
		UsersEntity ue = pb.getProfile(userid);
		if (ue != null && ue.getPwd().equals(pwd)) {
			firstName = ue.getFirstName();
			lastName = ue.getLastName();
			return "success";
		} else
			return "error";
	}

	public String textResponse() throws Exception {
		UsersEntity ue = pb.getProfile(userid);
		if (ue != null && ue.getPwd().equals(pwd)) {
			firstName = ue.getFirstName();
			lastName = ue.getLastName();
			inputStream = new StringBufferInputStream("successful login : text reponse");
			return SUCCESS;
		} else {
			inputStream = new StringBufferInputStream("failure login : text reponse");
			return SUCCESS;
		}
	}

	public String register() throws Exception {
		pb.register(userid, pwd);
		inputStream = new StringBufferInputStream("success");
		return SUCCESS;
	}

	public String update() throws Exception {
		pb.update(userid, pwd);
		inputStream = new StringBufferInputStream("success");
		return SUCCESS;
	}

	public String delete() throws Exception {
		pb.delete(userid);
		inputStream = new StringBufferInputStream("success");
		return SUCCESS;
	}

	// STRUTS REDIRECT PAGE DATA
	String firstName;
	String lastName;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public InputStream inputStream;
 

	HttpServletRequest httpReq;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.httpReq = request;
	}

}