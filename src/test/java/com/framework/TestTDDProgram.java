package com.framework;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.util.Calculator;
import com.util.TDD;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
public class TestTDDProgram {
	
	@Test
	public void test1EmptyUserid() {
		TDD t=new TDD();
		boolean res=t.login(null, "john1!");
		assertEquals(false, res);
	}	
	@Test
	public void test1EmptyPwd() {
		TDD t=new TDD();
		boolean res=t.login("john", null);
		assertEquals(false, res);
	}	
	@Test
	public void test1EmptyUseridAndPassword() {
		TDD t=new TDD();
		boolean res=t.login(null, null);
		assertEquals(false, res);
	}	
	@Test
	public void test1ValidUseridPwd() {
		TDD t=new TDD();
		boolean res=t.login("john", "john1!");
		assertEquals(true, res);
	}	
	@Test
	public void test1InValidUseridPwd() {
		TDD t=new TDD();
		boolean res=t.login("john", "john2@");
		assertEquals(false, res);
	}	
	
}
