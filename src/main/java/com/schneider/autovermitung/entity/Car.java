package com.schneider.autovermitung.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
@Column(name="model")
    private String model;
    @Column(name="brand")
    private String brand;
    @Column(name="price_per_day")
    private double pricePerDay;//Цена аренды за день.
    @Column(name="available")
    private boolean available = true;   //available: Статус доступности.


}
