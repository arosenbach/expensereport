package com.nelkinda.training;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String... args) {
        final ExpenseReport expenseReport = new ExpenseReport();
        final ExpensePolicy expensePolicy = new ExpensePolicy();
        expensePolicy.setMaxAmount(5000);
        expensePolicy.setRejectIfOversMaxAmount(true);
        final CostCenter costCenter = new CostCenter(expensePolicy);
        final Employee employee = new Employee("John","Doe", costCenter);
        expenseReport.printReport(List.of(
                new Expense(ExpenseType.BREAKFAST, 1000),
                new Expense(ExpenseType.DINNER, 5420),
                new Expense(ExpenseType.CAR_RENTAL, 1000)
        ),
                employee,
                new Date());
    }
}
