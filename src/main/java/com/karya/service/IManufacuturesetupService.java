package com.karya.service;

import java.util.List;

import com.karya.model.ManufactureSetup001MB;

public interface IManufacuturesetupService {
	
	public void addmanufacturesetup(ManufactureSetup001MB manufacturesetup001MB);

	public List<ManufactureSetup001MB> listmanufacturesetup();
	
	public ManufactureSetup001MB getmanufacturesetup(int mansetId);
	
	public void deletemanufacturesetup(int mansetId);


}
