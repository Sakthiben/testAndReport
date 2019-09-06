package com.karya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.karya.dao.IProductBundleDAO;
import com.karya.model.ProductBundle001MB;
import com.karya.service.IProductBundleService;

@Service("productbundleservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductBundleService implements IProductBundleService {
	
	@Autowired
	private IProductBundleDAO productbundledao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addproductbundle(ProductBundle001MB productbundlemb) {
		productbundledao.addproductbundle(productbundlemb);
	}
	
	public List<ProductBundle001MB> productbundlelist() {
		return productbundledao.productbundlelist();
	}
	
	public ProductBundle001MB getProductbundle(int id) {
		return productbundledao.getProductbundle(id);
	}
	
	public void deleteproductbundle(int id) {
		productbundledao.deleteproductbundle(id);
	}

}
