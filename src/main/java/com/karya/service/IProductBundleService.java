package com.karya.service;

import java.util.List;

import com.karya.model.ProductBundle001MB;

public interface IProductBundleService {
	
public List<ProductBundle001MB> productbundlelist();
	
	public void addproductbundle(ProductBundle001MB productbundlemb);
	
	public ProductBundle001MB getProductbundle(int id);

	public void deleteproductbundle(int id);

}
