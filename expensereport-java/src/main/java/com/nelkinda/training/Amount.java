package com.nelkinda.training;

import java.util.Objects;

public class Amount {
    public static final Amount MAX_VALUE = Amount.of(Integer.MAX_VALUE);
    final int value;

    private Amount(final int value) {
        this.value = value;
    }

    public static Amount of(final int value) {
        return new Amount(value);
    }

    public static Amount empty() {
        return new Amount(0);
    }

    public Amount sum(final Amount amount) {
        return Amount.of(amount.value + this.value);
    }


    public boolean isGreaterThan(final Amount otherAmount) {
        return value > otherAmount.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
