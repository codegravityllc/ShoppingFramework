package com.spring.beans.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 
public class Nissan implements ICar {
	  
	public Nissan(String s) {
	}
	@Override
	public void drive() {
		System.out.println("nissan");
	}

}
