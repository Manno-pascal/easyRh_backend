package com.manno.easyrh.dto;
import com.manno.easyrh.enums.GenderType;
import com.manno.easyrh.enums.PositionType;
import jakarta.validation.constraints.Pattern;
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

    private PositionType positionType;
    private GenderType gender;
    private int age;
    private int warning;
    private String comment;
    private boolean isRqth;
    private int dayOff;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String country;
    private String zip;
    private boolean isCeo;
    private boolean isRh;
    private CompanyDTO company;
}
