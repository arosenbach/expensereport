package com.nelkinda.training;

import java.util.Optional;

public class Employee {
    private final FullName fullName;
    final CostCenter costCenter;

    public Employee(final FullName fullName, final CostCenter costCenter) {
        this.fullName = fullName;
        this.costCenter = costCenter;
    }

    FullName getFullName() {
        return this.fullName;
    }

    public Optional<ExpenseReportStatus> computeExpenseReportStatus(int total) {
        return costCenter.computeReportStatus(total);
    }
}
