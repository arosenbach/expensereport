package com.nelkinda.training;

class Expense {
    public static final Amount DINNER_EXPENSE_MAX_AMOUNT = Amount.of(5000);
    public static final Amount BREAKFAST_EXPENSE_MAX_AMOUNT = Amount.of(1000);
    private final ExpenseType type;
    private final Amount amount;

    public ExpenseType getType() {
        return type;
    }

    public Amount getAmount() {
        return amount;
    }


    public Expense(final ExpenseType type, final Amount amount) {
        this.type = type;
        this.amount = amount;
    }

    String getMealOverExpensesMarker() {
        String mealOverExpensesMarker = " ";
        if (type == ExpenseType.DINNER && amount.isGreaterThan(DINNER_EXPENSE_MAX_AMOUNT) || type == ExpenseType.BREAKFAST && amount.isGreaterThan(BREAKFAST_EXPENSE_MAX_AMOUNT))
            mealOverExpensesMarker = "X";
        return mealOverExpensesMarker;
    }

    Amount computeMealExpenses(Amount mealExpenses) {
        if (getType() == ExpenseType.DINNER || getType() == ExpenseType.BREAKFAST) {
            mealExpenses =  mealExpenses.add(this.amount);
        }
        return mealExpenses;
    }

    String computeExpenseName() {
        String expenseName = "";
        switch (getType()) {
            case DINNER:
                expenseName = "Dinner";
                break;
            case BREAKFAST:
                expenseName = "Breakfast";
                break;
            case CAR_RENTAL:
                expenseName = "Car Rental";
                break;
        }
        return expenseName;
    }

    public String toString() {
        return computeExpenseName() + "\t" + this.amount + "\t" + getMealOverExpensesMarker();
    }
}
