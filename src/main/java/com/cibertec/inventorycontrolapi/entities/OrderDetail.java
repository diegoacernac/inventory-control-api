package com.cibertec.inventorycontrolapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "measuringUnit", nullable = false)
    private int measuringUnit;

    @Column(name = "isComplete", nullable = false)
    private Boolean isComplete;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @CreationTimestamp
    @Column(name = "registerDate", updatable = false, nullable = false)
    private LocalDateTime registerDate;

    @Column(name = "registerUser", length = 50, nullable = false)
    private String registerUser;

    @UpdateTimestamp
    @Column(name = "updateDate")
    private LocalDateTime updateDate;

    @Column(name = "updateUser", length = 50)
    private String updateUser;
}
