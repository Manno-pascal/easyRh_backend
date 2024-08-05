package com.manno.easyrh.dto;
import com.manno.easyrh.enums.GenderType;
import com.manno.easyrh.enums.PositionType;
import lombok.Data;

@Data
public class WorkerDTO {
    int id;
    String firstname;
    String lastname;
    String position;
    PositionType positionType;
    GenderType gender;
    int age;
    int warning;
    String comment;
    boolean isRqth;
    int dayOff;
    String phoneNumber;
    String email;
    String address;
    String city;
    String country;
    String zip;
    boolean isCeo;
    boolean isRh;
    CompanyDTO company;
}
