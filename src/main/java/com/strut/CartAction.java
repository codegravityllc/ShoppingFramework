package com.strut;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.beans.CartBean;

public class CartAction {
	String productName;
	ArrayList<String> cartDetails=new ArrayList<String> (); 
	
	@Autowired
	CartBean cb;
	public String add2Cart() {
		cartDetails=cb.add(productName);
		return "success";
	}
	
	
	public ArrayList<String> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(ArrayList<String> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
