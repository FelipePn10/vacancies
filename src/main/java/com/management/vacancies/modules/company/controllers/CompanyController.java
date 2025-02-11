package com.management.vacancies.modules.company.controllers;


import com.management.vacancies.exceptions.UserFoundExecption;
import com.management.vacancies.modules.company.entities.CompanyEntity;
import com.management.vacancies.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public CompanyEntity create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.createCompanyUseCase.execute(companyEntity);
            return ResponseEntity.ok(result).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserFoundExecption();
        }
    }
}
