package com.demo.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.models.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
