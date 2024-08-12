package com.manno.easyrh.dto;
import com.manno.easyrh.enums.GenderType;
import com.manno.easyrh.enums.PositionType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class WorkerDTO {
    private int id;
    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ' -]{1,100}$", message = "Prénom invalide.")
    private String firstname;

    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ' -]{1,100}$", message = "Nom invalide.")
    private String lastname;

    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ' -]{1,100}$", message = "Poste invalide.")
    private String position;
    @NotNull(message = "Le status est obligatoire.")
    private PositionType positionType;

    @NotNull(message = "Le genre est obligatoire.")
    private GenderType gender;

    @Min(value = 18, message = "L'âge doit être au moins 18.")
    @Max(value = 65, message = "L'âge doit être au plus 65.")
    private int age;

    @Min(value = 0, message = "Le nombre d'avertissements ne peut pas être négatif.")
    @Max(value = 10, message = "Le nombre d'avertissements ne peut pas dépasser 10.")
    private int warning;

    @Size(max = 500, message = "Le commentaire ne peut pas dépasser 500 caractères.")
    private String comment;

    private boolean isRqth;

    @Min(value = 0, message = "Le nombre de jours de congé ne peut pas être négatif.")
    @Max(value = 365, message = "Le nombre de jours de congé ne peut pas dépasser 365.")
    private int dayOff;

    @Pattern(regexp = "^(\\+33|0)[1-9](\\d{2}){4}$", message = "Numéro de téléphone invalide.")
    private String phoneNumber;

    @Email(message = "Email invalide.")
    private String email;

    @Pattern(regexp = "^[a-zA-Z0-9à-ÿÀ-Ÿ' ,.-]{1,255}$", message = "Adresse invalide.")
    private String address;

    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ' -]{1,100}$", message = "Ville invalide.")
    private String city;

    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ' -]{1,100}$", message = "Pays invalide.")
    private String country;

    @Pattern(regexp = "^[0-9]{4,10}$", message = "Code postal invalide.")
    private String zip;

    private boolean isCeo;

    private boolean isRh;
    private CompanyDTO company;
}
