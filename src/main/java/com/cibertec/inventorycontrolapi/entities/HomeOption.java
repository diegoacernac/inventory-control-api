package com.cibertec.inventorycontrolapi.entities;

import com.cibertec.inventorycontrolapi.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "homeOption")
public class HomeOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @Column(name = "routePath", length = 20, nullable = false)
    private String routePath;

    @Column(name = "routeImagePath", length = 100, nullable = false)
    private String routeImagePath;

    @Column(name = "userType", length = 20, nullable = false)
    private String userType;

    @Column(name = "menu", length = 2, nullable = false)
    private int menu;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    void setPrePersist() {
        this.status = Status.ACTIVE;
    }
}
