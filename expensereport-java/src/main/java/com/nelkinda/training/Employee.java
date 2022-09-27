package com.nelkinda.training;

public class Employee {
    private final FullName fullName;
    private final CostCenter costCenter;

    public Employee(final String firstName, final String lastName, final CostCenter costCenter) {
        this.fullName= new FullName(firstName, lastName);
        this.costCenter = costCenter;
    }

    public int computeCostCenterMaxAmount() {
        return this.costCenter.getExpensePolicy().getMaxAmount();
    }

    String computeEmployeeName() {
        return this.fullName.computeFullName();
    }

    public boolean hasCostCenterExpensePolicy() {
        return this.costCenter.hasExpensePolicy();
    }

    public boolean isRejectIfOversMaxAmount() {
        return this.costCenter.getExpensePolicy().rejectIfOversMaxAmount();
    }
}
