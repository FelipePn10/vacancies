package com.management.vacancies.modules.company.controllers;

import com.management.vacancies.modules.company.entities.JobEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.management.vacancies.modules.company.useCases.CreateJobUseCase;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity) {
        try {
            var result = this.createJobUseCase.execute(jobEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            return this.createJobUseCase.execute(jobEntity);
        }
    }
}
