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
public class TestStrutAction {
	private static final long serialVersionUID = 1L;

	// business logic methods
	public String login() {
		if(strutuid.equals("java") &&
			strutpwd.equals("jee")	
				)
			return "success";
		else
			return "failure";
	}
	
	// FORM BEAN
	public String strutuid;
	public String strutpwd;
	
	public String getStrutuid() {
		return strutuid;
	}


	public void setStrutuid(String strutuid) {
		this.strutuid = strutuid;
	}


	public String getStrutpwd() {
		return strutpwd;
	}


	public void setStrutpwd(String strutpwd) {
		this.strutpwd = strutpwd;
	}


}