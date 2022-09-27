package com.nelkinda.training;

public class CostCenter {
    private ExpensePolicy expensePolicy;

    public CostCenter(final ExpensePolicy expensePolicy) {
        this.expensePolicy = expensePolicy;
    }

    public boolean hasExpensePolicy() {
        return this.expensePolicy != null;
    }

    public ExpensePolicy getExpensePolicy() {
        return expensePolicy;
    }

    public int getExpensePolicyMaxAmount() {
        return expensePolicy.getMaxAmount();
    }
}
