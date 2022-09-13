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

    int computeMealExpenses(int mealExpenses) {
        if (getType() == ExpenseType.DINNER || getType() == ExpenseType.BREAKFAST) {
            mealExpenses += this.amount;
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
