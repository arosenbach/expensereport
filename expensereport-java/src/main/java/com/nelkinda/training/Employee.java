package com.nelkinda.training;

public class Employee {
    private final FullName fullName;
    final CostCenter costCenter;

    public Employee(final String firstName, final String lastName, final CostCenter costCenter) {
        this.fullName= new FullName(firstName, lastName);
        this.costCenter = costCenter;
    }

    String computeEmployeeName() {
        return this.fullName.computeFullName();
    }

}
