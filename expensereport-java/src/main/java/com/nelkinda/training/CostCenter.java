package com.nelkinda.training;

import java.util.Optional;

public class CostCenter {
    private ExpensePolicy expensePolicy;

    public CostCenter(final ExpensePolicy expensePolicy) {
        this.expensePolicy = expensePolicy;
    }

    public boolean hasExpensePolicy() {
        return this.expensePolicy != null;
    }

    public int getExpensePolicyMaxAmount() {
        return expensePolicy.getMaxAmount();
    }

    public boolean isRejectedByExpensePolicy() {
        return expensePolicy.rejectIfOversMaxAmount();
    }

    public Optional<String> computeReportStatus(int total, Employee employee) {
        if (hasExpensePolicy()) {
            if (getExpensePolicyMaxAmount() < total) {
                if (isRejectedByExpensePolicy()) {
                    return Optional.of("====== REJECTED ======");
                } else {
                    return Optional.of("====== ACCEPTED ======");
                }
            } else {
                return Optional.of("====== ACCEPTED ======");
            }
        }
        return Optional.empty();
    }
}
