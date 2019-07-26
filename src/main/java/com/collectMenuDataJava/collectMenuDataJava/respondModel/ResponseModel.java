package com.collectMenuDataJava.collectMenuDataJava.respondModel;

import java.util.List;

public class ResponseModel{
	private String price;
	private int rating;
	private String menuName;
	private int spicy;
	private int tag;
	private String menuImageUrl;

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setRating(int rating){
		this.rating = rating;
	}

	public int getRating(){
		return rating;
	}

	public void setMenuName(String menuName){
		this.menuName = menuName;
	}

	public String getMenuName(){
		return menuName;
	}

	public void setSpicy(int spicy){
		this.spicy = spicy;
	}

	public int getSpicy(){
		return spicy;
	}

	public void setTag(Integer tag){
		this.tag = tag;
	}

	public Integer getTag(){
		return tag;
	}

	public void setMenuImageUrl(String menuImageUrl){
		this.menuImageUrl = menuImageUrl;
	}

	public String getMenuImageUrl(){
		return menuImageUrl;
	}


}