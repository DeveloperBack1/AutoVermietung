package com.schneider.autovermietung.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;


/*
    @OneToMany(mappedBy = "customer")
    private List<Car> cars;*/


}
