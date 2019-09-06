package com.karya.service;

import java.util.List;

import com.karya.model.Asset001MB;

public interface IAssetService {

public List<Asset001MB> assetlist();
	
	public void addasset(Asset001MB dailytimesheet);
	
	public Asset001MB getAsset(int id);

	public void deleteasset(int id);
}
