package com.karya.service;

import java.util.List;

import com.karya.model.ItemGroup001MB;
import com.karya.model.ItemPrice001MB;
import com.karya.model.PricingRule001MB;
import com.karya.model.ProductBundle001MB;
import com.karya.model.ShippingRule001MB;

public interface IItemandPriceService {
	
	public void additemgroup(ItemGroup001MB itemgroup001MB);

	public List<ItemGroup001MB> listitemgroup();
	
	public ItemGroup001MB getitemgroup(int igId);
	
	public void deleteitemgroup(int igId);
	
	//Item Price
	
	public void additemprice(ItemPrice001MB itemprice001MB);

	public List<ItemPrice001MB> listitemprice();
	
	public ItemPrice001MB getitemprice(int ipId);
	
	public void deleteitemprice(int ipId);
	
	//Product Bundle
	
	public void addproductbundle(ProductBundle001MB productbundle001MB);

	public List<ProductBundle001MB> listproductbundle();
	
	public ProductBundle001MB getproductbundle(int pbundId);
	
	public void deleteproductbundle(int pbundId);
	
	//Pricing Rule
	
	public void addpricingrule(PricingRule001MB pricingrule001MB);

	public List<PricingRule001MB> listpricingrule();
	
	public PricingRule001MB getpricingrule(int priceruleid);
	
	public void deletepricingrule(int priceruleid);
	
	//ShippingRule
	
		public void addshippingrule(ShippingRule001MB shippingrule001MB);

		public List<ShippingRule001MB> listshippingrule();
		
		public ShippingRule001MB getshippingrule(int sruleId);
		
		public void deleteshippingrule(int sruleId);
		
		
	

}
