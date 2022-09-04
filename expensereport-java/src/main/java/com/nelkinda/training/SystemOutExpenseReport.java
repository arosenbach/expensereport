package com.nelkinda.training;

import java.util.Date;

public class SystemOutExpenseReport implements ExpenseReport {

    private final com.nelkinda.training.ExpenseFormatter formatter = new ExpenseFormatter();

    @Override
    public void printReport(ExpenseCollection expenses, final Employee employee, final Date date) {
        System.out.println("Expenses " + date);
        System.out.println(employee.getFirstName() + " " + employee.getLastName());
        expenses.stream()
                .map(expense -> expense.toString(formatter))
                .forEach(System.out::println);
        System.out.println("Meal expenses: " + expenses.calculateMealExpenses());
        final Amount total = expenses.calculateTotal();
        System.out.println("Total expenses: " + total);

        employee.hasCostCenterApproval(total)
                .ifPresent(this::printApprovalMessage);
    }

    private void printApprovalMessage(boolean approved) {
         System.out.println(Boolean.TRUE.equals(approved) ? "====== ACCEPTED ======" : "====== REJECTED ======");
    }

    public static class ExpenseFormatter implements com.nelkinda.training.ExpenseFormatter {

        private static final String EXCEEDED_AMOUNT_MARK = "X";
        public static final String NOT_EXDEEDED_AMOUNT_MARK = " ";

        @Override
        public String format(final ExpenseType type, final Amount amount, final boolean exceededAmount) {
            return type + "\t" + amount + "\t" + (type.isExceededAmount(amount) ? EXCEEDED_AMOUNT_MARK : NOT_EXDEEDED_AMOUNT_MARK);
        }
    }
}
