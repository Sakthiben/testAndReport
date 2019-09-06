package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IItemsandPriceDao;
import com.karya.model.ItemGroup001MB;
import com.karya.model.ItemPrice001MB;
import com.karya.model.PricingRule001MB;
import com.karya.model.ProductBundle001MB;
import com.karya.model.ShippingRule001MB;
import com.karya.service.IItemandPriceService;

@Service("itempriceService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemandPriceServiceImpl implements IItemandPriceService{
	
	@Autowired
	private IItemsandPriceDao itempriceDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void additemgroup(ItemGroup001MB itemgroup001MB) {
		itempriceDao.additemgroup(itemgroup001MB);
	}
	
	public List<ItemGroup001MB> listitemgroup() {
		return itempriceDao.listitemgroup();
	}

	public ItemGroup001MB getitemgroup(int igId) {
		return itempriceDao.getitemgroup(igId);
	}
	
	public void deleteitemgroup(int igId) {
		itempriceDao.deleteitemgroup(igId);
	}
	
	//Item Price
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void additemprice(ItemPrice001MB itemprice001MB) {
		itempriceDao.additemprice(itemprice001MB);
	}
	
	public List<ItemPrice001MB> listitemprice() {
		return itempriceDao.listitemprice();
	}

	public ItemPrice001MB getitemprice(int ipId) {
		return itempriceDao.getitemprice(ipId);
	}
	
	public void deleteitemprice(int ipId) {
		itempriceDao.deleteitemprice(ipId);
	}
	
	//Product Bundle
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addproductbundle(ProductBundle001MB productbundle001MB) {
		itempriceDao.addproductbundle(productbundle001MB);
	}
	
	public List<ProductBundle001MB> listproductbundle() {
		return itempriceDao.listproductbundle();
	}

	public ProductBundle001MB getproductbundle(int pbundId) {
		return itempriceDao.getproductbundle(pbundId);
	}
	
	public void deleteproductbundle(int pbundId) {
		itempriceDao.deleteproductbundle(pbundId);
	}
	
	//pricing rule
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addpricingrule(PricingRule001MB pricingrule001MB) {
		itempriceDao.addpricingrule(pricingrule001MB);
	}
	
	public List<PricingRule001MB> listpricingrule() {
		return itempriceDao.listpricingrule();
	}

	public PricingRule001MB getpricingrule(int priceruleid) {
		return itempriceDao.getpricingrule(priceruleid);
	}
	
	public void deletepricingrule(int priceruleid) {
		itempriceDao.deletepricingrule(priceruleid);
	}
	
	
	//shipping rule
	
		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public void addshippingrule(ShippingRule001MB shippingrule001MB) {
			itempriceDao.addshippingrule(shippingrule001MB);
		}
		
		public List<ShippingRule001MB> listshippingrule() {
			return itempriceDao.listshippingrule();
		}

		public ShippingRule001MB getshippingrule(int sruleId) {
			return itempriceDao.getshippingrule(sruleId);
		}
		
		public void deleteshippingrule(int sruleId) {
			itempriceDao.deleteshippingrule(sruleId);
		}
		
	
	
	
	
	
	

}
