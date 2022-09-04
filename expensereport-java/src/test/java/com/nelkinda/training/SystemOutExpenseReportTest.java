package com.nelkinda.training;

import org.approvaltests.ApprovalUtilities;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Date;

class SystemOutExpenseReportTest {

    @Test
    void emptyReport() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final SystemOutExpenseReport sut = new SystemOutExpenseReport();

        // Act
        final CostCenter costCenter = new CostCenter(null);
        sut.printReport(ExpenseCollection.empty(), new Employee("John", "Doe", costCenter), new Date(0));

        // Assert
        Approvals.verify(output);
    }

    @Test
    void reportNoPolicy() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final SystemOutExpenseReport sut = new SystemOutExpenseReport();

        // Act
        sut.printReport(ExpenseCollection.of(
                        new Expense(ExpenseType.DINNER, Amount.of(5000)),
                        new Expense(ExpenseType.DINNER, Amount.of(5001)),
                        new Expense(ExpenseType.BREAKFAST, Amount.of(1000)),
                        new Expense(ExpenseType.BREAKFAST, Amount.of(1001)),
                        new Expense(ExpenseType.CAR_RENTAL, Amount.of(99999999))
                ),
                new Employee("Jane", "Doe", new CostCenter(null)),
                new Date(0));

        // Assert
        Approvals.verify(output);
    }


    @Test
    void reportWithEmptyPolicy() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final ExpenseReport sut = new SystemOutExpenseReport();

        // Act
        final ExpensePolicy expensePolicy = new ExpensePolicy(Amount.empty(), false);
        sut.printReport(ExpenseCollection.of(
                        new Expense(ExpenseType.CAR_RENTAL, Amount.of(99999999))
                ),
                new Employee("Jane", "Doe", new CostCenter(expensePolicy)),
                new Date(0));

        // Assert
        Approvals.verify(output);
    }

    @Test
    void reportWithPolicyAccepted() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final ExpenseReport sut = new SystemOutExpenseReport();

        // Act
        final ExpensePolicy expensePolicy = new ExpensePolicy(Amount.MAX_VALUE, true);
        sut.printReport(ExpenseCollection.of(
                        new Expense(ExpenseType.CAR_RENTAL, Amount.of(99999999))
                ),
                new Employee("Jane", "Doe", new CostCenter(expensePolicy)),
                new Date(0));

        // Assert
        Approvals.verify(output);
    }

    @Test
    void reportWithPolicyRejected() {
        // Arrange
        final ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        final ExpenseReport sut = new SystemOutExpenseReport();

        // Act
        final ExpensePolicy expensePolicy = new ExpensePolicy(Amount.of(100), true);
        sut.printReport(ExpenseCollection.of(
                        new Expense(ExpenseType.CAR_RENTAL, Amount.of(99999999))
                ),
                new Employee("Jane", "Doe", new CostCenter(expensePolicy)),
                new Date(0));
        // Assert
        Approvals.verify(output);
    }

}