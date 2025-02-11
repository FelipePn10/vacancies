package com.management.vacancies.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jdk.jfr.Description;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID   id;
    @Pattern( regexp = "\\S+", message = "O campo [nome] não pode conter espaços.")
    private String username;
    @Email(message = "Preencha com seu e-mail.")
    private String email;
    @Length(min = 6, max = 10, message = "A senha deve conter entre 6 e 10 caracteres.")
    private String password;
    @URL(message = "Preencha com o link do site da empresa.")
    private String website;
    @Description(value = "Descrição da empresa.")
    private String description;
    private String address;
    @CreationTimestamp
    private LocalDateTime created_at;
    //private String avatar;
    private String phone;
    private String cnpj;

}
