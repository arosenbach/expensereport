package com.nelkinda.training;

public class FullName {
    private final String firstName;
    private final String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String computeFullName() {
        return firstName + " " + lastName;
    }
}