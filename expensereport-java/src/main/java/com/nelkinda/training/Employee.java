package com.nelkinda.training;

public class Employee {
    private String firstName;
    private String lastName;
    private CostCenter costCenter;

    public Employee(final String firstName, final String lastName, final CostCenter costCenter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.costCenter = costCenter;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }
}
