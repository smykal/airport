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
@Table(name = "PASSENGERS")

@SecondaryTables(
        {
                @SecondaryTable(name = "ADDRESSES",
                        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER ID", referencedColumnName = "PASSENGER ID")),

                @SecondaryTable(name = "PHONES",
                        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER ID", referencedColumnName = "PASSENGER ID"))
        }
)
public class Passenger {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STREET", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
    private String street;

    @Column(name = "NUMBER", table = "ADDRESSES", columnDefinition = "varchar(10) not null")
    private String number;

    @Column(name = "ZIPCODE", table = "ADDRESSES", columnDefinition = "varchar(10) not null")
    private String zipcode;

    @Column(name = "CITY", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
    private String city;

    @Column(name = "AREA_CODE", table = "PHONES", columnDefinition = "varchar(5) not null")
    private String areaCode;

    @Column(name = "PREFIX", table = "PHONES", columnDefinition = "varchar(3) not null")
    private String prefix;

    @Column(name = "LINE_NUMBER", table = "PHONES", columnDefinition = "varchar(9) not null")
    private String lineNumber;

    @ManyToOne
    @JoinColumn(name = "AIRPORT_ID")
    private Airport airport;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
