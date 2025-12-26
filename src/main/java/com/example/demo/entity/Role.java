package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter; // If using Lombok
import lombok.Setter; // If using Lombok

@Entity
@Table(name = "roles")
@Getter // Automatically generates getName()
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // Manually add this if NOT using Lombok @Getter
    public String getName() {
        return name;
    }
}
