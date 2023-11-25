package com.cibertec.inventorycontrolapi.controllers;

import com.cibertec.inventorycontrolapi.entities.ProductInventory;
import com.cibertec.inventorycontrolapi.services.ProductInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-inventory")
public class ProductInventoryController {
    private final ProductInventoryService productInventoryService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productInventoryService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/active")
    public ResponseEntity<?> findAllActive() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productInventoryService.findAllActive());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            ProductInventory productInventory = productInventoryService.findById(id);

            if (productInventory == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(productInventory, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ProductInventory productInventory) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(productInventoryService.save(productInventory));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductInventory productInventory) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productInventoryService.update(id, productInventory));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productInventoryService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
