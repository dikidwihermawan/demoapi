package com.demo.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.models.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
