package com.management.vacancies.modules.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "job")
@Data
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //JOB
    private UUID id;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Benefits is required")
    private String benefits;
    @NotBlank(message = "Level is required")
    private String level;
    @NotBlank(message = "Requirements is required")
    private String requirements;
    @NotBlank(message = "Salary is required")
    private String salary;
    @NotBlank(message = "Location is required")
    private String location;
    @NotBlank(message = "Title is required")
    private String title;
    @CreationTimestamp
    private LocalDateTime created_at;
    //Company
    @ManyToOne()
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;
    @Column(name = "company_id",  nullable = false)
    private String company_id;

//    private String company_name;
//    private String company_logo;
//    private String company_description;
//    private String company_website;
//    private String company_email;
//    private String company_phone;
//    private String company_address;
}
