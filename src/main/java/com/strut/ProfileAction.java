package com.strut;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
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
	// UI FORM DATA
		public String userid;
		public String pwd;
		public String getUserid() { return userid; }
		public void setUserid(String userid) { this.userid = userid; }
		public String getPwd() { return pwd; }
		public void setPwd(String pwd) { this.pwd = pwd; }
	// UI FORM DATA

	// STRUTS BUSINESS METHOD
		@Autowired
		ProfileBean pb;
		public String execute() throws Exception {
			UsersEntity ue = pb.getProfile(userid);
			myList1.add("apple"); myList1.add("banana"); myList1.add("mango");
			if (ue != null && ue.getPwd().equals(pwd)) {
				firstName = ue.getFirstName();
				lastName = ue.getLastName();
				return "success";
			} else
				return "error";
		}
	// STRUTS BUSINESS METHOD
		
	// STRUTS REDIRECT PAGE DATA
		String firstName;
		String lastName;
		ArrayList<String> myList1=new ArrayList<String>();
		public ArrayList<String> getMyList1() { return myList1; }
		public void setMyList1(ArrayList<String> myList1) { this.myList1 = myList1; }
		public String getFirstName() { return firstName; }
		public String getLastName() { return lastName; }
		
	// STRUTS REDIRECT PAGE DATA


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

	public String verify() throws Exception {
		boolean res=pb.verifyCredentials(userid, pwd);
		if(res)
			inputStream = new StringBufferInputStream("success");
		else
			inputStream = new StringBufferInputStream("failure");
		return SUCCESS;
	}

	public String register() throws Exception {
			pb.register(userid, pwd);
		inputStream = new StringBufferInputStream("success");
		return SUCCESS;
	}

	public String update() throws Exception {
		boolean res=pb.update(userid, pwd);
		if(res)
			inputStream = new StringBufferInputStream("success");
		else
			inputStream = new StringBufferInputStream("failure");
		return SUCCESS;
	}

	public String delete() throws Exception {
		boolean res=pb.delete(userid);
		if(res)
			inputStream = new StringBufferInputStream("success");
		else
			inputStream = new StringBufferInputStream("failure");
		return SUCCESS;
	}
	public InputStream inputStream;
 

	HttpServletRequest httpReq;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.httpReq = request;
	}

}