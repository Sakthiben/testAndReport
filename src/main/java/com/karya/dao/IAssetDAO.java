package com.karya.dao;

import java.util.List;

import com.karya.model.Asset001MB;

public interface IAssetDAO {

	public List<Asset001MB> assetlist();
	
	public void addasset(Asset001MB assetmb);
	
	public Asset001MB getAsset(int id);
	
	public void deleteasset(int id);
}
