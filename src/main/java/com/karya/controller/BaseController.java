package com.karya.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;


@Controller
public class BaseController {
	
	public @Value("${Submit.Success}") String submitSuccess;
	
	public @Value("${Update.Success}") String updateSuccess;
	
	public @Value("${Delete.Success}") String deleteSuccess;
	
	public String menulink;

	public String getMenulink() {
		return menulink;
	}

	public void setMenulink(String menulink) {
		this.menulink = menulink;
	}
	
}


