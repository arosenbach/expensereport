package com.nelkinda.training;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExpenseCollection {
    final List<Expense> expenses;

    private ExpenseCollection(final Expense... expenses) {
        this.expenses = Arrays.asList(expenses);
    }

    public static ExpenseCollection of(final Expense... expenses) {
        return new ExpenseCollection(expenses);
    }

    public static ExpenseCollection empty() {
        return new ExpenseCollection();
    }

    public Amount calculateTotal() {
        return expenses.stream()
                .map(Expense::getAmount)
                .reduce(Amount.empty(), Amount::sum);
    }

    public Amount calculateMealExpenses() {
        return expenses.stream()
                .map(Expense::calculateMealAmount)
                .reduce(Amount.empty(), Amount::sum);
    }

    public Stream<Expense> stream() {
        return expenses.stream();
    }
}
