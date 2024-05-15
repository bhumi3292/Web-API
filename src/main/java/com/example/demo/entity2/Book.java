package com.example.demo.entity2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="id"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "ground_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="id"))
    private Ground ground;

    public void setName(String bookName) {
    }

    // Constructors, getters, and setters
}