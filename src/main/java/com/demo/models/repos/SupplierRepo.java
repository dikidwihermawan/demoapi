package com.demo.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.models.entities.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {

}
