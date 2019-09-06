package com.karya.dao;

import java.util.List;

import com.karya.model.GrossProfit001MB;

public interface IGrossProfitDAO {

public List<GrossProfit001MB> grossprofitlist();
	
	public void addgrossprofit(GrossProfit001MB grossprofitmb);
	
	public GrossProfit001MB getGrossprofit(int id);
	
	public void deletegrossprofit(int id);
}
