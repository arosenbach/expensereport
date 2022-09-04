package com.nelkinda.training;

import java.util.Date;

public interface ExpenseReport {
    void printReport(ExpenseCollection expenses, Employee employee, Date date);
}
