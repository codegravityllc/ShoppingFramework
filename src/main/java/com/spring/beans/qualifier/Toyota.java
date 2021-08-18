package com.spring.beans.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 
public class Toyota implements ICar {

	@Override
	public void drive() {
		System.out.println("Toyota");
	}

}
