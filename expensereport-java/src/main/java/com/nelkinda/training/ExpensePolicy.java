package com.nelkinda.training;

public class ExpensePolicy {
    private int maxAmount = 0;
    private boolean rejectIfOversMaxAmount = false;

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setRejectIfOversMaxAmount(final boolean rejectIfOversMaxAmount) {
        this.rejectIfOversMaxAmount = rejectIfOversMaxAmount;
    }

    public ExpenseReportStatus computeExpenseReportStatus(int total) {
        return maxAmount < total && rejectIfOversMaxAmount ?
                ExpenseReportStatus.REJECTED :
                ExpenseReportStatus.ACCEPTED;
    }
}
