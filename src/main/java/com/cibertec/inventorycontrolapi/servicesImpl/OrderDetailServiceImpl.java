package com.cibertec.inventorycontrolapi.servicesImpl;

import com.cibertec.inventorycontrolapi.entities.OrderDetail;
import com.cibertec.inventorycontrolapi.repositories.OrderDetailRepository;
import com.cibertec.inventorycontrolapi.services.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() throws Exception {
        try {
            return orderDetailRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public OrderDetail findById(Long id) throws Exception {
        try {
            return orderDetailRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) throws Exception {
        try {
            return orderDetailRepository.save(orderDetail);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public OrderDetail update(Long id, OrderDetail orderDetail) throws Exception {
        try {
            boolean isPresent = orderDetailRepository.findById(id).isPresent();
            return isPresent ? orderDetailRepository.save(orderDetail) : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
