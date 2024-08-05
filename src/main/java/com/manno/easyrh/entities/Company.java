package com.manno.easyrh.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity //On map cette classe comme étant une entité pour l'orm
@Table(name = "COMPANY") //Référence de la table dans le db pour l'orm
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company implements UserDetails {
    @Id //On spécifie que la colonne Id est la clée primaire (en gros)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //On spécifie que l'id est en autoincrement directement dans le db
    private int id;
    @Column(name = "company_name")
    private String companyName;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
    @Column(name = "ceo_firstname")
    private String ceoFirstname;
    @Column(name = "ceo_lastname")
    private String ceoLastname;
    @Column(name = "contact_firstname")
    private String contactFirstname;
    @Column(name = "contact_lastname")
    private String contactLastname;
    private String domain;
    @JsonIgnore
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }
}
