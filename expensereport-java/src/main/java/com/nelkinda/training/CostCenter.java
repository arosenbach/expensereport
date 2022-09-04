package com.nelkinda.training;

import java.util.Optional;

public class CostCenter {
    private final ExpensePolicy expensePolicy;

    public CostCenter(final ExpensePolicy expensePolicy) {
        this.expensePolicy = expensePolicy;
    }

    public Optional<Boolean> isRejected(final Amount total) {
        return Optional.ofNullable(this.expensePolicy)
                .map(policy -> policy.isRejected(total));
    }
}
