package com.management.vacancies.exceptions;

public class UserFoundExecption extends RuntimeException {
    public UserFoundExecption() {
        super("User already exists.");
    }
}
