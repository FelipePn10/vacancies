package com.management.vacancies.modules.candidate.useCases;

import com.management.vacancies.exceptions.UserFoundExecption;
import com.management.vacancies.modules.candidate.CandidateEntity;
import com.management.vacancies.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                 .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                 .ifPresent((user) -> {
                    throw new UserFoundExecption();
                 });
             return this.candidateRepository.save(candidateEntity);
    }
}

