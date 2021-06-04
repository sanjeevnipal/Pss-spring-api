package com.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapi.dao.ProductApiDao;
import com.productapi.entity.Product;


@RestController // this is a rest controller class
@CrossOrigin //to allow on different ip address (cors policy)
@RequestMapping("/api/products")
public class ProductApiController {

	@Autowired
	private ProductApiDao prodDao;

	// list all products using get method
	@GetMapping //
	List<Product> listAll() {
		return prodDao.findAll();
	}

	// find a Specific product by id
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return prodDao.findById(id).orElse(null);
	}

	// save product
	@PostMapping
	public Product save(@RequestBody Product product) {
		return prodDao.save(product);
	}

	// delete by id
	@DeleteMapping("/{id}")
	public List<Product> delete(@PathVariable int id) {
		prodDao.deleteById(id);
		return prodDao.findAll();
		
	
	}

	// update product
	@PutMapping
	public Product update(@RequestBody Product product) {
		return prodDao.save(product);
	}
}
