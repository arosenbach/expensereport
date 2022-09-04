package com.nelkinda.training;

import java.util.Optional;

public class Employee {
    private String firstName;
    private String lastName;
    private CostCenter costCenter;

    public Employee(final String firstName, final String lastName, final CostCenter costCenter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.costCenter = costCenter;
    }

    public Optional<Boolean> hasCostCenterApproval(final Amount total) {
        return costCenter.isRejected(total)
                .map(Boolean.FALSE::equals);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
