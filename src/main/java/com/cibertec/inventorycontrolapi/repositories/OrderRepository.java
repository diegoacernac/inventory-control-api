package com.cibertec.inventorycontrolapi.repositories;

import com.cibertec.inventorycontrolapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT MAX(o.orderCode) FROM Order o WHERE o.orderCode LIKE :datePrefix%")
    String findLastOrderCode(@Param("datePrefix") String datePrefix);
}
