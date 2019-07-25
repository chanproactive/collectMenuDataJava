package com.collectMenuDataJava.collectMenuDataJava.Menu;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MenuListItem{
	@NotNull
	private String price;
	@NotNull
	private String menuName;
}
