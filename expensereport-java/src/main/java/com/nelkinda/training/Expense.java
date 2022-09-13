package com.nelkinda.training;

class Expense {
    private ExpenseType type;
    private int amount;

    public ExpenseType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }


    public Expense(final ExpenseType type, final int amount) {
        this.type = type;
        this.amount = amount;
    }

    String getMealOverExpensesMarker() {
        String mealOverExpensesMarker = " ";
        if (type == ExpenseType.DINNER && amount > 5000 || type == ExpenseType.BREAKFAST && amount > 1000)
            mealOverExpensesMarker = "X";
        return mealOverExpensesMarker;
    }
}
