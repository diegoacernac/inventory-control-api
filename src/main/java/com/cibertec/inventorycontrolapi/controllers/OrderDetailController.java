package com.cibertec.inventorycontrolapi.controllers;

import com.cibertec.inventorycontrolapi.entities.OrderDetail;
import com.cibertec.inventorycontrolapi.services.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-detail")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(orderDetailService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            OrderDetail orderDetail = orderDetailService.findById(id);

            if (orderDetail == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(orderDetail, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody OrderDetail orderDetail) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(orderDetailService.save(orderDetail));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody OrderDetail orderDetail) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(orderDetailService.update(id, orderDetail));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
