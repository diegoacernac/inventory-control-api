package com.cibertec.inventorycontrolapi.services;

import com.cibertec.inventorycontrolapi.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll() throws Exception;
    Order findById(Long id) throws Exception;
    Order save(Order order) throws Exception;
    Order update(Long id, Order order) throws Exception;
}
