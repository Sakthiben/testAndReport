package com.karya.dao;

import java.util.List;

import com.karya.model.MaterialReqnotCreate001MB;
import com.karya.model.PuItemHistory001MB;
import com.karya.model.ReqItemOrdBuy001MB;
import com.karya.model.RequestedItemBuy001MB;

public interface IBuyingReportsDao {
	
	public void addmatreqnotcreate(MaterialReqnotCreate001MB materialreqnotcreate001MB);

	public List<MaterialReqnotCreate001MB> listmatreqnotcreate();
	
	public MaterialReqnotCreate001MB getmatreqnotcreate(int mrsId);
	
	public void deletematreqnotcreate(int mrsId);
	
	//reqitem order buy
	
	public void addreqitemordbuy(ReqItemOrdBuy001MB reqitemordbuy001MB);

	public List<ReqItemOrdBuy001MB> listreqitemordbuy();
	
	public ReqItemOrdBuy001MB getreqitemordbuy(int mrsId);
	
	public void deletereqitemordbuy(int mrsId);
	
	
	//req item buy
	
	public void addreqitembuy(RequestedItemBuy001MB requseteditembuy001MB);

	public List<RequestedItemBuy001MB> listreqitembuy();
	
	public RequestedItemBuy001MB getreqitembuy(int riId);
	
	public void deletereqitembuy(int riId);
	
	//PuItem History
	
	public void addpuitemhistory(PuItemHistory001MB puitemhistory001MB);

	public List<PuItemHistory001MB> listpuitemhistory();
	
	public PuItemHistory001MB getpuitemhistory(int histId);
	
	public void deletepuitemhistory(int histId);
	
	
	
	
	
	
	
	

}
