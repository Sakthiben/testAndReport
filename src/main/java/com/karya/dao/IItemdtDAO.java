package com.karya.dao;
import java.util.List;

import com.karya.model.Itemdt001MB;
import com.karya.model.Order001MB;
import com.karya.model.SalesOrder001MB;

public interface IItemdtDAO {
	
	public void itemdtAddAction(Itemdt001MB itemdt001MB);
	public Itemdt001MB itemdtEditAction(int itemId);
	public void itemDeleteAction(int itemId);
	public List<Itemdt001MB> listallItems();
	public List<SalesOrder001MB> listallSOrder();
	public List<Order001MB> listallOrder();
	public void orderAdd(Order001MB order001mb);
	public Order001MB orderEdit(int orderId);
	public void orderDelete(int orderId);
	
	public void soAdd(SalesOrder001MB salesOrder);
	public SalesOrder001MB soEdit(int salesId );
	public void soDelete(int salesId);

}
