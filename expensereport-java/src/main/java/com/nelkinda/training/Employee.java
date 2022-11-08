package com.nelkinda.training;

import java.util.Optional;

public class Employee {
    private final FullName fullName;
    final CostCenter costCenter;

    public Employee(final FullName fullName, final CostCenter costCenter) {
        this.fullName = fullName;
        this.costCenter = costCenter;
    }

    String computeEmployeeName() {
        return this.fullName.computeFullName();
    }

    public Optional<ExpenseReportStatus> computeExpenseReportStatus(int total) {
        return costCenter.computeReportStatus(total);
    }
}
