package com.nelkinda.training;

import java.util.Date;

public class Main {

    public static void main(String... args) {
        final ExpenseReport expenseReport = new SystemOutExpenseReport();
        final ExpensePolicy expensePolicy = new ExpensePolicy(Amount.of(5000), true);
        final CostCenter costCenter = new CostCenter(expensePolicy);
        final Employee employee = new Employee("John", "Doe", costCenter);
        expenseReport.printReport(ExpenseCollection.of(
                new Expense(ExpenseType.BREAKFAST, Amount.of(1000)),
                new Expense(ExpenseType.DINNER, Amount.of(5420)),
                new Expense(ExpenseType.CAR_RENTAL, Amount.of(1000))
        ), 
         employee,
                new Date());
    }
}
