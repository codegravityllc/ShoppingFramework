package com.spring.beans;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class CartBean {
	ArrayList<String> cartList = new ArrayList<String>();
	public ArrayList<String> add(String prodName){
		cartList.add(prodName);
		return cartList;
	}
}
