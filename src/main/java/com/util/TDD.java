package com.util;

public class TDD {
	public boolean login(String userid,String pwd) {
		if(userid ==null)
			return false;
		if(pwd==null)
			return false;
		if(userid.equals("john") && pwd.equals("john1!"))
			return true;
		else
			return false;
	}
}
