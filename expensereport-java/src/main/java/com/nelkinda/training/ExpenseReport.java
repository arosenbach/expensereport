package com.nelkinda.training;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ExpenseReport {
    // TODO: move to Employee class
    public void printReport(List<Expense> expenses, Employee employee, Date date) {
        Amount total = Amount.EMPTY;
        Amount mealExpenses = Amount.EMPTY;

        System.out.println("Expenses " + date);
        System.out.println(employee.getFullName());

        for (Expense expense : expenses) {
            mealExpenses = expense.computeMealExpenses(mealExpenses);

            System.out.println(expense);

            total = total.add(expense.getAmount());
        }

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);


        Optional<ExpenseReportStatus> status = employee.computeExpenseReportStatus(total.getValue());
        status
                .map(this::toStatusString)
                .ifPresent(System.out::println);
    }

    private String toStatusString(ExpenseReportStatus expenseReportStatus) {
        if (expenseReportStatus.equals(ExpenseReportStatus.ACCEPTED)) {
            return "====== ACCEPTED ======";
        }
        return "====== REJECTED ======";
    }

}
