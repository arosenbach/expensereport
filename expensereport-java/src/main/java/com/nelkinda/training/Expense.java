package com.nelkinda.training;

class Expense {
    private final ExpenseType type;
    private final Amount amount;

    public Expense(final ExpenseType type, final Amount amount) {
        this.type = type;
        this.amount = amount;
    }

    public Amount calculateMealAmount() {
        return this.type.isMeal() ? amount : Amount.empty();
    }

    public String toString(ExpenseFormatter formatter) {
        return formatter.format(type, amount, type.isExceededAmount(this.amount));
    }

    public Amount getAmount() {
        return amount;
    }
}
