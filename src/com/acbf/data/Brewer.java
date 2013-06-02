package com.acbf.data;

public class Brewer {
	private String mName;
	private String mLocation;
	private String mWebsite;
	private String mTwitter;
	private int    mBrewerId;
	
	public Brewer(String name, String location, String website, String twitter, int brewerId) {
		mName = name;
		mLocation = location;
		mWebsite = website;
		mTwitter = twitter;
		mBrewerId = brewerId;
	}

	public String getName() {
		return mName;
	}

	public String getLocation() {
		return mLocation;
	}

	public String getWebsite() {
		return mWebsite;
	}

	public String getTwitter() {
		return mTwitter;
	}

	public int getBrewerId() {
		return mBrewerId;
	}

}
