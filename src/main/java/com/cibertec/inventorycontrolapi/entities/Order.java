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
@Table(name = "orderHead")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user", length = 50, nullable = false)
    private String user;

    @ManyToOne
    @JoinColumn(name = "providerId", nullable = false)
    private Provider provider;

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
        this.status = Status.PENDING;
    }
}
