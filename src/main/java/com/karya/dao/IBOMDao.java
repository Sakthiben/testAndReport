package com.karya.dao;

import java.util.List;

import com.karya.model.ItemStatus001MB;
import com.karya.model.OperationBOM001MB;
import com.karya.model.WorkStation001MB;

public interface IBOMDao {
	
	public void additemst(ItemStatus001MB itemstatus001MB);

	public List<ItemStatus001MB> listitemst();
	
	public ItemStatus001MB getitemst(int itemstId);
	
	public void deleteitemst(int itemstId);
	
	//Workstation details
	
	public void addworkstn(WorkStation001MB workstation001MB);

	public List<WorkStation001MB> listworkstn();
	
	public WorkStation001MB getworkstn(int workstId);
	
	public void deleteworkstn(int workstId);
	
	//Operation details
	
	public void addoperation(OperationBOM001MB operationbom001MB);

	public List<OperationBOM001MB> listoperation();
	
	public OperationBOM001MB getoperation(int opId);
	
	public void deleteoperation(int opId);
	
	
	
	
	
	

}
