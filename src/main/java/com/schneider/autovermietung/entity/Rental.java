package com.schneider.autovermietung.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="rentals")
public class Rental {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private int id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "total_cost")
    private double totalCost;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return id == rental.id && Double.compare(totalCost, rental.totalCost) == 0
                && Objects.equals(startDate, rental.startDate)
                && Objects.equals(endDate, rental.endDate)
                && Objects.equals(customer, rental.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, totalCost, customer);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalCost=" + totalCost +
                ", customer=" + customer +
                '}';
    }
}