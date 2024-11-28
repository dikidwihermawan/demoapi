package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.ResponseData;
import com.demo.dto.SearchData;
import com.demo.models.entities.Product;
import com.demo.models.entities.Supplier;
import com.demo.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<ResponseData<Product>> save(@Valid @RequestBody Product product, Errors errors) {
        ResponseData<Product> response = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                response.getMessages().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        response.setStatus(true);
        response.setPayload(productService.save(product));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product, Errors errors) {
        ResponseData<Product> response = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                response.getMessages().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        response.setStatus(true);
        response.setPayload(productService.save(product));
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.removeOne(id);
    }

    @PostMapping("/{id}")
    public void addSupplier(@RequestBody Supplier supplier, @PathVariable("id") Long productId) {
        productService.addSupplier(supplier, productId);
    }

    @PostMapping("/search/name")
    public Product getProductByName(@RequestBody SearchData searchData) {
        return productService.findProductByName(searchData.getSearchKey());
    }

    @PostMapping("/search/namelike")
    public List<Product> getProductByNameLike(@RequestBody SearchData searchData) {
        return productService.findProductByNameLike(searchData.getSearchKey());
    }

    @GetMapping("/search/category/{categoryId}")
    public List<Product> getProductByCategory(@PathVariable("categoryId") Long categoryId) {
        return productService.findProductByCategory(categoryId);
    }

    @GetMapping("/search/supplier/{supplierId}")
    public List<Product> getProductBySupplier(@PathVariable("supplierId") Long supplierId) {
        return productService.findProductBySupplier(supplierId);
    }
}
