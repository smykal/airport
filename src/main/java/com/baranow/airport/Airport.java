package com.baranow.airport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "AIRPORTS")
public class Airport {

    @Id
    @Column(name = "ID")
    @Access(AccessType.FIELD)
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "airport")
    private List<Passenger> passengers = new ArrayList<>();

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public void addPassanger(Passenger passenger) {
        passengers.add(passenger);
    }

    public Airport(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
