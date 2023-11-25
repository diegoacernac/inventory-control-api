package com.cibertec.inventorycontrolapi.entities;

import com.cibertec.inventorycontrolapi.enums.Status;
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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 150, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

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
