package com.nelkinda.training;

public class ExpensePolicy {
    private final Amount maxAmount;
    private final boolean rejectIfOversMaxAmount;

    public ExpensePolicy(final Amount maxAmount, final boolean rejectIfOversMaxAmount) {
        this.maxAmount = maxAmount;
        this.rejectIfOversMaxAmount = rejectIfOversMaxAmount;
    }

    public boolean isRejected(final Amount total) {
        return total.isGreaterThan(maxAmount) && rejectIfOversMaxAmount;
    }
}
