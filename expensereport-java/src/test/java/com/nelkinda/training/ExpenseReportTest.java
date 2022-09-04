package com.nelkinda.training;

import org.approvaltests.ApprovalUtilities;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class ExpenseReportTest {

    @Test
    void emptyReport() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final ExpenseReport sut = new ExpenseReport();

        // Act
        sut.printReport(Collections.emptyList(), new Date(0));

        // Assert
        Approvals.verify(output);
    }

    @Test
    void nonEmptyReport() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final ExpenseReport sut = new ExpenseReport();

        // Act
        sut.printReport(List.of(
                new Expense(ExpenseType.DINNER, 5000),
                new Expense(ExpenseType.DINNER, 5001),
                new Expense(ExpenseType.BREAKFAST, 1000),
                new Expense(ExpenseType.BREAKFAST, 1001),
                new Expense(ExpenseType.CAR_RENTAL, 99999999)
        ), new Date(0));

        // Assert
        Approvals.verify(output);
    }

}