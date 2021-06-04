package com.productapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productapi.entity.Product;

public interface ProductApiDao extends JpaRepository<Product, Integer> {

}
