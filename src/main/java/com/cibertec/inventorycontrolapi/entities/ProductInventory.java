package com.cibertec.inventorycontrolapi.entities;

import com.cibertec.inventorycontrolapi.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productInventory")
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productInventoryId", nullable = false)
    private Product product;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "measuringUnit", nullable = false)
    private String measuringUnit;

    @Column(name = "batch", length = 20, nullable = false)
    private String batch;

    @Column(name = "purchasePrice", nullable = false)
    private double purchasePrice;

    @Column(name = "salePrice", nullable = false)
    private double salePrice;

    @Column(name = "dueDate", nullable = false)
    private Date dueDate;

    @Enumerated(EnumType.STRING)
    private Status status;

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

    @PrePersist
    void setPrePersist() {
        this.status = Status.ACTIVE;
    }
}
