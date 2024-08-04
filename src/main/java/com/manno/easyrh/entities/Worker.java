package com.manno.easyrh.entities;

import com.manno.easyrh.enums.GenderType;
import com.manno.easyrh.enums.PositionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "WORKER")
@Setter
@Getter
@AllArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String position;
    private PositionType positionType;
    private GenderType gender;
    private int age;
    private int warning;
    private String comment;
    private boolean isRqth;
    private int day_off;
    private String phone_number;
    private String email;
    private String address;
    private String city;
    private String country;
    private String zip;
    private boolean isCeo;
    private boolean isRh;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "COMPANY")
    private Company company;

    public Worker() {

    }
}
