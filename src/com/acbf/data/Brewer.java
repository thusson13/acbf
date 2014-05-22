package com.acbf.data;

public class Brewer {
	private String mName;
	private String mLocation;
	private String mTwitter;
	private int    mBrewerId;
	
	public Brewer(String name, String location, String website, String twitter, int brewerId) {
		mName = name;
		mLocation = location;
		mTwitter = twitter;
		mBrewerId = brewerId;
	}

	public String getName() {
		return mName;
	}

	public String getLocation() {
		return mLocation;
	}

	public String getTwitter() {
		return mTwitter;
	}

	public int getBrewerId() {
		return mBrewerId;
	}

}
