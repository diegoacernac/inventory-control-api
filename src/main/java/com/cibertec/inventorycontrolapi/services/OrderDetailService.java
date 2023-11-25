package com.cibertec.inventorycontrolapi.services;

import com.cibertec.inventorycontrolapi.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAll() throws Exception;
    OrderDetail findById(Long id) throws Exception;
    OrderDetail save(OrderDetail orderDetail) throws Exception;
    OrderDetail update(Long id, OrderDetail orderDetail) throws Exception;
}
