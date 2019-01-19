package com.bhaiti.kela.beans;

public class Articles {
	String title;
	String fullUrl;
	
	Articles(String name, String url){
		this.title = name;
		this.fullUrl = url;
	}
	public String getName() {
		return title;
	}
	public void setName(String name) {
		this.title = name;
	}
	
	public String getURL() {
		return fullUrl;
	}
	public void setURL(String url) {
		this.fullUrl = url;
	}
}
