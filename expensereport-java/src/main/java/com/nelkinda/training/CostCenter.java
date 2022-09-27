package com.nelkinda.training;

import java.util.Optional;

public class CostCenter {
    private ExpensePolicy expensePolicy;

    public CostCenter(final ExpensePolicy expensePolicy) {
        this.expensePolicy = expensePolicy;
    }

    public Optional<ExpenseReportStatus> computeReportStatus(int total) {
        return Optional.ofNullable(this.expensePolicy).map(policy -> computeExpenseReportStatus(policy, total));
    }

    private ExpenseReportStatus computeExpenseReportStatus(ExpensePolicy policy, int total) {
        if (policy.getMaxAmount() < total) {
            if (policy.rejectIfOversMaxAmount()) {
                return ExpenseReportStatus.REJECTED;
            } else {
                return ExpenseReportStatus.ACCEPTED;
            }
        } else {
            return ExpenseReportStatus.ACCEPTED;
        }
    }
}
