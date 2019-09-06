package com.karya.dao;

import java.util.List;

import com.karya.model.DeliveryNoteTrend001MB;
import com.karya.model.PURecptTrend001MB;

public interface IStockAnalyticsDao {

	public void adddelnotetrends(DeliveryNoteTrend001MB deliverynotetrend001MB);

	public List<DeliveryNoteTrend001MB> listdelnotetrends();
	
	public DeliveryNoteTrend001MB getdelnotetrends(int dntrendId);
	
	public void deletedelnotetrends(int dntrendId);
	
	// Purchase receipt
	
	public void addpurecpttrend(PURecptTrend001MB purecpttrend001MB);

	public List<PURecptTrend001MB> listpurecpttrend();
	
	public PURecptTrend001MB getpurecpttrend(int putrendId);
	
	public void deletepurecpttrend(int putrendId);
	
	
}
