package com.nelkinda.training;

enum ExpenseType {
    DINNER("Dinner", Amount.of(5000), true),
    BREAKFAST("Breakfast", Amount.of(1000), true),
    CAR_RENTAL("Car Rental", Amount.MAX_VALUE, false);

    private final String name;
    private final Amount maxAmount;
    private final boolean mealExpenseType;

    ExpenseType(final String name, final Amount maxAmount, final boolean mealExpenseType) {
        this.name = name;
        this.maxAmount = maxAmount;
        this.mealExpenseType = mealExpenseType;
    }

    public boolean isMeal() {
        return mealExpenseType;
    }

    public boolean isExceededAmount(final Amount amount) {
        return amount.isGreaterThan(maxAmount);
    }

    @Override
    public String toString() {
        return name;
    }
}
