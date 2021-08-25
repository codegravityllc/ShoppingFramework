package com.framework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.hibernate.springdata.UsersEntity;
import com.spring.beans.ProfileBean;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Spring_ModelLayerTest {
	
	public ProfileBean profile; // scanned in test spring config class

	@Autowired
	public void setProfile(ProfileBean profile) {
		this.profile = profile;
	}

	@Test
	public void test1register() throws Exception {
		profile.register("tester", "t123");
		boolean res=profile.verifyCredentials("tester", "t123");
		assertTrue(res);
	}
	@Test
	public void test2verify() throws Exception {
		boolean res=profile.verifyCredentials("tester", "t123");
		assertTrue(res);
	}
	@Test
	public void test3update() throws Exception {
		profile.update("tester", "t12345");
		boolean res=profile.verifyCredentials("tester", "t12345");
		assertTrue(res);
	}
	@Test
	public void test4delete() throws Exception {
		profile.delete("tester");
		UsersEntity ue=profile.getProfile("tester");
		assertNull(ue);
	}
}
