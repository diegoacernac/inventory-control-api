package com.cibertec.inventorycontrolapi.controllers;

import com.cibertec.inventorycontrolapi.entities.HomeOption;
import com.cibertec.inventorycontrolapi.services.HomeOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/home-option")
@CrossOrigin
@RequiredArgsConstructor
public class HomeOptionController {
    private final HomeOptionService homeOptionService;

    @GetMapping("/listar")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(homeOptionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllByUser() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(homeOptionService.findByUserType());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/menu/{menu}")
    public ResponseEntity<?> getAllByMenu(@PathVariable int menu) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(homeOptionService.findByMenuType(menu));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            HomeOption homeOption = homeOptionService.findById(id);

            if (homeOption == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(homeOption, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody HomeOption homeOption) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(homeOptionService.save(homeOption));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update/id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HomeOption homeOption) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(homeOptionService.update(id, homeOption));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(homeOptionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
