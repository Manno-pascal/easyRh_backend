package com.manno.easyrh.model;

import com.manno.easyrh.enums.GenderType;
import com.manno.easyrh.enums.PositionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "WORKER")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String position;
    @Column(name = "position_type")
    private PositionType positionType;
    private GenderType gender;
    private int age;
    private int warning;
    private String comment;
    @Column(name = "is_rqth")
    private boolean isRqth;
    @Column(name = "day_off")
    private int dayOff;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String country;
    private String zip;
    @Column(name = "is_ceo")
    private boolean isCeo;
    @Column(name = "is_rh")
    private boolean isRh;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "COMPANY")
    private Company company;
}
