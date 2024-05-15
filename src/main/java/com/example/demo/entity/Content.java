package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="contexts")
public class Content{
    @GeneratedValue(generator="contexts_seq_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="contexts_seq_gen",sequenceName="contexts_seq",allocationSize = 1)
    @Id
    private Integer id;

    @Column(name="context_name",nullable=false,length=100)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "information_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_contexts_information_id"))
    private com.example.demo.entity.information information;

}


