package com.cibertec.inventorycontrolapi.services;


import com.cibertec.inventorycontrolapi.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll() throws Exception;
    List<Product> findAllActive() throws Exception;
    Product findById(Long id) throws Exception;
    Product save(Product product) throws Exception;
    Product update(Long id, Product product) throws Exception;
    Product delete(Long id) throws Exception;
}
