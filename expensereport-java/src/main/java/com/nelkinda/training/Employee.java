package com.nelkinda.training;

public class Employee {
    private final FullName fullName;
    private final CostCenter costCenter;

    public Employee(final String firstName, final String lastName, final CostCenter costCenter) {
        this.fullName= new FullName(firstName, lastName);
        this.costCenter = costCenter;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    String computeEmployeeName() {
        return this.fullName.computeFullName();
    }
}
