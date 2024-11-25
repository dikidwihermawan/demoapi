package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.entities.Product;
import com.demo.models.repositories.ProductRepositories;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepositories productRepositories;

    public List<Product> findAll() {
        return productRepositories.findAll();
    }

    public Optional<Product> findOne(Long id) {
        return productRepositories.findById(id);
    }

    public Product save(Product product) {
        return productRepositories.save(product);
    }

    public void delete(Long id) {
        productRepositories.deleteById(id);
    }

}
