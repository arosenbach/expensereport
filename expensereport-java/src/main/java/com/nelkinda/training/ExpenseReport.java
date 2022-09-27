package com.nelkinda.training;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ExpenseReport {
    public void printReport(List<Expense> expenses, Employee employee, Date date) {
        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + date);
        System.out.println(employee.computeEmployeeName());

        for (Expense expense : expenses) {
            mealExpenses = expense.computeMealExpenses(mealExpenses);

            System.out.println(expense);

            total += expense.getAmount();
        }

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);


        Optional<String> status = computeReportStatus(employee, total);
        status.ifPresent(System.out::println);
    }

    private Optional<String> computeReportStatus(Employee employee, int total) {
        if (employee.hasCostCenterExpensePolicy()) {
            final int costCenterMaxAmount = employee.computeCostCenterMaxAmount();
            if (costCenterMaxAmount < total) {
                if (employee.isRejectIfOversMaxAmount()) {
                    return Optional.of("====== REJECTED ======");
                } else {
                    return Optional.of("====== ACCEPTED ======");
                }
            } else {
                return Optional.of("====== ACCEPTED ======");
            }
        }
        return Optional.empty();
    }

}
