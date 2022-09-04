package com.nelkinda.training;

public interface ExpenseFormatter {
    String format(ExpenseType type, Amount amount, boolean exceededAmount);
}
