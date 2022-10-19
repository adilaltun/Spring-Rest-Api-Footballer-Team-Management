package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    @NotBlank(message = "Lütfen adınızı giriniz!")
    private String name;

    @NotBlank(message = "Lütfen soyadınızı giriniz!")
    private String surname;

    @Column(unique = true)
    @Email(message = "Email formatı hatalı")
    private String email;

    private String password;

    @Min(value = 18,message = "Lütfen 18 yaş ve üstü bir değer giriniz!")
    private Integer age;

}
