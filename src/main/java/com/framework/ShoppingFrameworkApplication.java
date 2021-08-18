package com.framework;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@ComponentScan({ "com.config", "com.spring"  })
@EnableJpaRepositories("com.hibernate")
@EntityScan({"com.hibernate"})
@EnableTransactionManagement
public class ShoppingFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingFrameworkApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		StrutsPrepareAndExecuteFilter struts = new StrutsPrepareAndExecuteFilter();
		registrationBean.setFilter(struts);
		registrationBean.setOrder(1);
		return registrationBean;
	}
	 
}
