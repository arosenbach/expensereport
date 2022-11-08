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
        final CostCenter costCenter = new CostCenter(null);
        sut.printReport(Collections.emptyList(), new Employee(new FullName("John", "Doe"), costCenter), new Date(0));

        // Assert
        Approvals.verify(output);
    }

    @Test
    void reportNoPolicy() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final ExpenseReport sut = new ExpenseReport();

        // Act
        sut.printReport(List.of(
                new Expense(ExpenseType.DINNER, Amount.of(5000)),
                new Expense(ExpenseType.DINNER, Amount.of(5001)),
                new Expense(ExpenseType.BREAKFAST, Amount.of(1000)),
                new Expense(ExpenseType.BREAKFAST, Amount.of(1001)),
                new Expense(ExpenseType.CAR_RENTAL, Amount.of(99999999))
        ),
                new Employee(new FullName("Jane", "Doe"), new CostCenter(null)),
                new Date(0));

        // Assert
        Approvals.verify(output);
    }

    @Test
    void reportWithEmptyPolicy() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final ExpenseReport sut = new ExpenseReport();

        // Act
        final ExpensePolicy expensePolicy = new ExpensePolicy();
        sut.printReport(List.of(
                        new Expense(ExpenseType.CAR_RENTAL, Amount.of(99999999))
                ),
                new Employee(new FullName("Jane", "Doe"), new CostCenter(expensePolicy)),
                new Date(0));

        // Assert
        Approvals.verify(output);
    }

    @Test
    void reportWithPolicyAccepted() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final ExpenseReport sut = new ExpenseReport();

        // Act
        final ExpensePolicy expensePolicy = new ExpensePolicy();
        expensePolicy.setMaxAmount(Integer.MAX_VALUE);
        expensePolicy.setRejectIfOversMaxAmount(true);
        sut.printReport(List.of(
                        new Expense(ExpenseType.CAR_RENTAL, Amount.of(99999999))
                ),
                new Employee(new FullName("Jane", "Doe"), new CostCenter(expensePolicy)),
                new Date(0));

        // Assert
        Approvals.verify(output);
    }

    @Test
    void reportWithPolicyRejected() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final ExpenseReport sut = new ExpenseReport();

        // Act
        final ExpensePolicy expensePolicy = new ExpensePolicy();
        expensePolicy.setMaxAmount(100);
        expensePolicy.setRejectIfOversMaxAmount(true);
        sut.printReport(List.of(
                        new Expense(ExpenseType.CAR_RENTAL, Amount.of(99999999))
                ),
                new Employee(new FullName("Jane", "Doe"), new CostCenter(expensePolicy)),
                new Date(0));

        // Assert
        Approvals.verify(output);
    }

}