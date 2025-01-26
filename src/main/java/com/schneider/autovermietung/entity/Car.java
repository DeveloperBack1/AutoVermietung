package com.schneider.autovermietung.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    /**
     * Цена аренды за день
     */
    @Column(name = "price_per_day")
    private double pricePerDay;

    /**
     * Статус доступности
     */
    @Column(name = "available")
    private boolean available = true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Double.compare(pricePerDay, car.pricePerDay) == 0 &&
                available == car.available &&
                Objects.equals(model, car.model) &&
                Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, pricePerDay, available);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", available=" + available +
                '}';
    }
}