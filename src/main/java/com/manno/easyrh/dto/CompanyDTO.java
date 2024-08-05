package com.manno.easyrh.dto;
import lombok.Data;


@Data
public class CompanyDTO {
    private int id;
    private String companyName;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
    private String ceoFirstname;
    private String ceoLastname;
    private String contactFirstname;
    private String contactLastname;
    private String domain;
    private String password;
}
