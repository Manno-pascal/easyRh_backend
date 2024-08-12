package com.manno.easyrh.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class CompanyDTO {
    private int id;

    @Pattern(regexp = "^[A-Za-z0-9&\\-',.\\s]{2,100}$", message = "Nom d'entreprise invalide.")
    private String companyName;

    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\u00C0-\\u017F\\s'-.]{2,100}$", message = "Nom de ville invalide.")
    private String city;

    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ0-9\\s,.'#/-]{5,100}$", message = "Adresse invalide.")
    private String address;

    @Pattern(regexp = "^(\\+33|0)[1-9](\\d{2}){4}$", message = "Numéro de téléphone invalide.")
    private String phoneNumber;

    @Email(message = "Adresse email invalide")
    private String email;

    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ' -]{1,100}$", message = "Prénom du CTO invalide.")
    private String ceoFirstname;

    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ' -]{1,100}$", message = "Nom du CTO invalide.")
    private String ceoLastname;

    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ' -]{1,100}$", message = "Prénom du contact invalide.")
    private String contactFirstname;

    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ' -]{1,100}$", message = "Nom du contact invalide.")
    private String contactLastname;

    @Pattern(regexp = "^[a-zA-ZÀ-ÿ0-9\\s'-,.]{2,100}$", message = "Domaine invalide.")
    private String domain;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", message = "Mot de passe invalide.")
    private String password;
}
