package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name="informations")
public class information {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "informations_seq_gen")
    @SequenceGenerator(name = "informations_seq_gen", sequenceName = "informations_seq", allocationSize = 1)

    @Id
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;
}
