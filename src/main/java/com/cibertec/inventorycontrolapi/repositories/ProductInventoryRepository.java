package com.cibertec.inventorycontrolapi.repositories;

import com.cibertec.inventorycontrolapi.entities.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {
}
