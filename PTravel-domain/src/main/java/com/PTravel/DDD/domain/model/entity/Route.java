package com.PTravel.DDD.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private double distance;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station originStation;

    @ManyToOne
    private Station destinationStation;
}