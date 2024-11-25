package com.demo.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.models.entities.Product;

public interface ProductRepositories extends JpaRepository<Product, Long> {

}
