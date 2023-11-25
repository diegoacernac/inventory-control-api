package com.cibertec.inventorycontrolapi.repositories;

import com.cibertec.inventorycontrolapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
