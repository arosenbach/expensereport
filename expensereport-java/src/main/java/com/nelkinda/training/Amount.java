package com.nelkinda.training;

public class Amount {
    final public static Amount EMPTY = of(0);
    private final int value;

    public static Amount of(int value) {
        return new Amount(value);
    }

    private Amount(int value) {
        this.value = value;
    }

    public Amount add(Amount valueToAdd) {
        return Amount.of(this.value + valueToAdd.value);
    }

    // todo: to remove
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public boolean isGreaterThan(Amount other) {
        return this.value > other.value;
    }
}
