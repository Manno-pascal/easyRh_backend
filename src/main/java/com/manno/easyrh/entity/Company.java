package com.manno.easyrh.entity;

import jakarta.persistence.*;


@Entity //On map cette classe comme étant une entité pour l'orm
@Table(name = "COMPANY") //Référence de la table dans le db pour l'orm
public class Company {
    @Id //On spécifie que la colonne Id est la clée primaire (en gros)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //On spécifie que l'id est en autoincrement directement dans le db
    private int id;
    private String company_name;
    private String city;
    private String address;
    private String phone_number;
    private String email;
    private String ceo_firstname;
    private String ceo_lastname;
    private String contact_firstname;
    private String contact_lastname;
    private String domain;
    private String password;

    public Company(int id, String company_name, String city, String address, String phone_number, String email, String ceo_firstname, String ceo_lastname, String contact_firstname, String contact_lastname, String domain, String password) {
        this.id = id;
        this.company_name = company_name;
        this.city = city;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.ceo_firstname = ceo_firstname;
        this.ceo_lastname = ceo_lastname;
        this.contact_firstname = contact_firstname;
        this.contact_lastname = contact_lastname;
        this.domain = domain;
        this.password = password;
    }

    public Company() {
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCeoFirstname() {
        return ceo_firstname;
    }

    public void setCeoFirstname(String ceo_firstname) {
        this.ceo_firstname = ceo_firstname;
    }

    public String getCeoLastname() {
        return ceo_lastname;
    }

    public void setCeoLastname(String ceo_lastname) {
        this.ceo_lastname = ceo_lastname;
    }

    public String getContactFirstname() {
        return contact_firstname;
    }

    public void setContactFirstname(String contact_firstname) {
        this.contact_firstname = contact_firstname;
    }

    public String getContactLastname() {
        return contact_lastname;
    }

    public void setContactLastname(String contact_lastname) {
        this.contact_lastname = contact_lastname;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
