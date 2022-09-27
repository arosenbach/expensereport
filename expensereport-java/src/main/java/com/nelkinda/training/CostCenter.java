package com.nelkinda.training;

import java.util.Optional;

public class CostCenter {
    private ExpensePolicy expensePolicy;

    public CostCenter(final ExpensePolicy expensePolicy) {
        this.expensePolicy = expensePolicy;
    }

    public Optional<ExpenseReportStatus> computeReportStatus(int total) {
        if (this.expensePolicy != null) {
            if (expensePolicy.getMaxAmount() < total) {
                if (expensePolicy.rejectIfOversMaxAmount()) {
                    return Optional.of(ExpenseReportStatus.REJECTED);
                } else {
                    return Optional.of(ExpenseReportStatus.ACCEPTED);
                }
            } else {
                return Optional.of(ExpenseReportStatus.ACCEPTED);
            }
        }
        return Optional.empty();
    }
}
