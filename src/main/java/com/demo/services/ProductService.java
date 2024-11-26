package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.entities.Product;
import com.demo.models.repos.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product findOne(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return null;
        }

        return product.get();
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

}
