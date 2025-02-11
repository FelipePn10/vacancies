package com.management.vacancies.modules.company.useCases;

import com.management.vacancies.exceptions.UserFoundExecption;
import com.management.vacancies.modules.company.entities.CompanyEntity;
import com.management.vacancies.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundExecption();
                });
        return this.companyRepository.save(companyEntity);
    }
}
