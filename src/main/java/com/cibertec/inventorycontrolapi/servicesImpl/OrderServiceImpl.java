package com.cibertec.inventorycontrolapi.servicesImpl;

import com.cibertec.inventorycontrolapi.entities.Order;
import com.cibertec.inventorycontrolapi.repositories.OrderRepository;
import com.cibertec.inventorycontrolapi.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            order.setOrderCode(generateOrderCode());
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private String generateOrderCode() {
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Obtener el último número secuencial y agregar 1
        String lastOrderCode = orderRepository.findLastOrderCode("OR");
        int sequenceNumber = 1;
        if (lastOrderCode != null) {
            String lastSequence = lastOrderCode.substring(lastOrderCode.lastIndexOf('-') + 1);
            sequenceNumber = Integer.parseInt(lastSequence) + 1;
        }

        // Formatear el número secuencial a tres dígitos
        String formattedSequence = String.format("%03d", sequenceNumber);

        return "OR" + formattedDate + "-" + formattedSequence;
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
