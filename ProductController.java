  package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.services.ProductServices;

@RestController
public class ProductController 
{
	@Autowired
	ProductServices productService;

	@GetMapping("/api")
	public List<Product>getallProduct(){
		List<Product>products=new ArrayList<Product>();
		products.add(new Product("P001","Tea",10));
		products.add(new Product("P002","Milk",11));
		products.add(new Product("P003","Coffee",12));
		products.add(new Product("P004","cake",13));

		return products;
		
	}
	
//	@GetMapping("/api/users")
//	public List<Product>getallProduct1(){
//		List<Product>products=new ArrayList<Product>();
//		products=productService.getallProducts();
//		
//		
//		return products;
//		
//	}
	
	@GetMapping("/api/users")
	public List<Product>getallProduct1(){
		List<Product>products=new ArrayList<Product>();
		products=productService.getallProducts();
		
		
		return products;
		
	}
		
		@PostMapping("/api")
		public String saveProduct(@RequestBody Product product) {
			
			productService.saveProduct(product);
			
//			System.out.println("Product Id Recieved: "+product.getProductId());
//			System.out.println("Product Name Recieved: "+product.getProductName());
//			System.out.println("Product Price Recieved: "+product.getProductPrice());
			return "product recieved";
		} 
		
		@GetMapping("/api/users/{id}")
		public Product getProduct(@PathVariable String id)
		{
			Product product=productService.getProduct(id);
			return product;
		}
		
		@DeleteMapping("/users/{id}")
			public String deleteProduct(@PathVariable String id)
			{
				productService.deleteProduct(id);
				return "product deleted with ID "+id;
			}
		
		@PutMapping("/api/users/{id}")
		public Product updateProduct(@PathVariable String id,@RequestBody Product product)
		{
			Product newproduct=productService.updateProduct(id, product);
			return newproduct;
		}
	}