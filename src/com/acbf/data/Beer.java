package com.acbf.data;

public class Beer {
	//"brew":"Wheelers Brown","style":"American Brown Ale","abv":"5.7"
	private String mName;
	private int mBrewerId;
	private String mStyle;
	private double mAbv;
	
	public Beer(String name, int brewerId, String style, double abv) {
		mName = name;
		mBrewerId = brewerId;
		mStyle = style;
		mAbv = abv;
	}
	
	public String getName() {
		return mName;
	}
	
	public int getBrewerId() {
		return mBrewerId;
	}
	
	public String getStyle() {
		return mStyle;
	}
	
	public double getAbv() {
		return mAbv;
	}
}
