package com.management.vacancies.modules.company.repositories;

import com.management.vacancies.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID>{
}
