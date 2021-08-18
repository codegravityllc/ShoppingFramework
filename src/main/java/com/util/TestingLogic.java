package com.util;

public class TestingLogic {

	public static void main(String[] args) {
		String premiumRange="50$ To 500$";
		System.out.println(premiumRange);
		int minRange=-1;
		int maxRange=-1;
		premiumRange=premiumRange.replaceAll("\\$", "");
		premiumRange=premiumRange.replaceAll(" ", "");
		String [] tempRange=premiumRange.split("To");
		minRange=Integer.parseInt(tempRange[0]);
		maxRange=Integer.parseInt(tempRange[1]);
		System.out.println(minRange);
		System.out.println(maxRange);
	}

}
