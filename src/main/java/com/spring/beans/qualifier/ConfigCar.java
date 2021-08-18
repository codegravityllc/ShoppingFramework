package com.spring.beans.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigCar {

	@Bean(name="nissa")
	public Nissan getNis()
	{
		String myInputToNisssanObject="hello";
		return new Nissan(myInputToNisssanObject);
	}
	@Bean(name="to")
	public Toyota getTo()
	{
		return new Toyota();
	}
}
