package com.nelkinda.training;

public class ExpensePolicy {
    private int maxAmount = 0;
    private boolean rejectIfOversMaxAmount = false;

    public int getMaxAmount() {
        return maxAmount;
    }

    public boolean rejectIfOversMaxAmount() {
        return rejectIfOversMaxAmount;
    }

    public void setMaxAmount(int maxAmount){
        this.maxAmount = maxAmount;
    }

    public void setRejectIfOversMaxAmount(final boolean rejectIfOversMaxAmount) {
        this.rejectIfOversMaxAmount = rejectIfOversMaxAmount;
    }
}
