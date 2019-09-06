package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IGrossProfitDAO;
import com.karya.model.GrossProfit001MB;
import com.karya.service.IGrossProfitService;

@Service("grossprofitservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GrossProfitService implements IGrossProfitService{
	
	@Autowired
	private IGrossProfitDAO grossprofitdao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addgrossprofit(GrossProfit001MB grossprofit) {
		grossprofitdao.addgrossprofit(grossprofit);
	}
	
	public List<GrossProfit001MB> grossprofitlist() {
		return grossprofitdao.grossprofitlist();
	}
	
	public GrossProfit001MB getGrossprofit(int id) {
		return grossprofitdao.getGrossprofit(id);
	}
	
	public void deletegrossprofit(int id) {
		grossprofitdao.deletegrossprofit(id);
	}

}
