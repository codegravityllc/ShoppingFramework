package com.spring.beans;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hibernate.springdata.UserRepository;
import com.hibernate.springdata.UsersEntity;

@Service
@Scope("session")
public class ProfileBean {
	public UsersEntity ue;
	String name;
	ArrayList<String> cartList = new ArrayList<String>();
	
	// hibernate session
	//public static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	// Spring Data DI	
	@Autowired
	public UserRepository ur;

	public UsersEntity getProfile(String userid) {
		List<UsersEntity> ueList =ur.findByUid(userid);
		if(ueList.size() > 0)
			return ueList.get(0);
		else
			return null;
	}
	public boolean verifyCredentials(String userid, String pwd) {
		List<UsersEntity> ueList =ur.verify(userid, pwd);
		if(ueList.size() == 0)
			return false;
		else
			return true;
	}
	public void register(String userid, String pwd) {
		UsersEntity ue=new UsersEntity();
		ue.setUid(userid);
		ue.setPwd(pwd);
		ur.save(ue);
	}
	public boolean update(String userid, String pwd) {
		int i=ur.update(userid, pwd);
		if(i==0)
			return false;
		else
			return true;
	}
	public boolean delete(String userid) {
		int i=ur.delete(userid);
		if(i==0)
			return false;
		else
			return true;
	}
}
