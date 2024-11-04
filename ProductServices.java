package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductDao;

@Service
public class ProductServices {
@Autowired
private ProductDao productDao;
public void saveProduct(Product product) {
	productDao.save(product);

}

public List<Product>getallProducts(){
	List<Product>products=productDao.findAll();
	return products;
	
}

public Product getProduct(String id)
{
	Optional<Product> product=productDao.findById(id);
	return product.get();
}

public void deleteProduct(String id)
{
	productDao.deleteById(id);
}

public Product updateProduct(String id,Product product)
{
	Optional<Product>uproduct=productDao.findById(id);
	Product p=uproduct.get();
	p.setName(product.getName());
	p.setPrice(product.getPrice());
	productDao.save(p);
	return p;
}

}