package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IAssetDAO;
import com.karya.model.Asset001MB;
import com.karya.service.IAssetService;

@Service("assetservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AssetService implements IAssetService  {

	@Autowired
	private IAssetDAO assetdao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addasset(Asset001MB assetmb) {
		assetdao.addasset(assetmb);
	}
	
	public List<Asset001MB> assetlist() {
		return assetdao.assetlist();
	}
	
	public Asset001MB getAsset(int id) {
		return assetdao.getAsset(id);
	}
	
	public void deleteasset(int id) {
		assetdao.deleteasset(id);
	}

}
