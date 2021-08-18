package com.spring.beans;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hibernate.springdata.UserRepository;
import com.hibernate.springdata.UsersEntity;

@Component
@Scope("session")
public class ProfileBean {
	public UsersEntity ue;

	// hibernate session
	//public static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	// Spring Data DI	
	@Autowired
	public UserRepository ur;

	public UsersEntity getProfile(String userid) {
		List<UsersEntity> ueList =ur.findByUid(userid);
		return ueList.get(0);
	}
	public void register(String userid, String pwd) {
		UsersEntity ue=new UsersEntity();
		ue.setUid(userid);
		ue.setPwd(pwd);
		ur.save(ue);
	}
	public void update(String userid, String pwd) {
		ur.update(userid, pwd);
	}
	public void delete(String userid) {
		ur.delete(userid);
	}
}
