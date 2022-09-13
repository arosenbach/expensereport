package com.nelkinda.training;

import java.util.Date;
import java.util.List;

enum ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}

class Expense {
    ExpenseType type;
    int amount;

    public Expense(final ExpenseType type, final int amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class ExpenseReport {
    public void printReport(List<Expense> expenses, Employee employee, Date date) {
        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + date);
        System.out.println(employee.getFirstName() + " " + employee.getLastName());

        for (Expense expense : expenses) {
            mealExpenses = computeMealExpenses(mealExpenses, expense);

            String expenseName = computeExpenseName(expense);

            String mealOverExpensesMarker = " ";
            if (expense.type == ExpenseType.DINNER && expense.amount > 5000 || expense.type == ExpenseType.BREAKFAST && expense.amount > 1000)
                mealOverExpensesMarker = "X";

            System.out.println(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker);

            total += expense.amount;
        }

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);


        if (employee.getCostCenter().hasExpensePolicy()) {
            final int costCenterMaxAmount = employee.getCostCenter().getExpensePolicy().getMaxAmount();
            if (costCenterMaxAmount < total) {
                if (employee.getCostCenter().getExpensePolicy().rejectIfOversMaxAmount()) {
                    System.out.println("====== REJECTED ======");
                } else {
                    System.out.println("====== ACCEPTED ======");
                }
            } else {
                System.out.println("====== ACCEPTED ======");
            }
        }
    }

    private static String computeExpenseName(Expense expense) {
        String expenseName = "";
        switch (expense.type) {
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

    private static int computeMealExpenses(int mealExpenses, Expense expense) {
        if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST) {
            mealExpenses += expense.amount;
        }
        return mealExpenses;
    }
}
