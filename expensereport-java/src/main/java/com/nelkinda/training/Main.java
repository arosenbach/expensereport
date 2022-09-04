package com.nelkinda.training;

import java.util.List;

public class Main {

    public static void main(String... args) {
        final ExpenseReport expenseReport = new ExpenseReport();
        expenseReport.printReport(List.of(
                new Expense(ExpenseType.BREAKFAST, 1000),
                new Expense(ExpenseType.DINNER, 5420),
                new Expense(ExpenseType.CAR_RENTAL, 1000)
        ));
    }
}
