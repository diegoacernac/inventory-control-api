package com.cibertec.inventorycontrolapi.servicesImpl;

import com.cibertec.inventorycontrolapi.entities.Order;
import com.cibertec.inventorycontrolapi.repositories.OrderRepository;
import com.cibertec.inventorycontrolapi.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() throws Exception {
        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Order findById(Long id) throws Exception {
        try {
            return orderRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Order save(Order order) throws Exception {
        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Order update(Long id, Order order) throws Exception {
        try {
            boolean isPresent = orderRepository.findById(id).isPresent();
            return isPresent ? orderRepository.save(order) : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
