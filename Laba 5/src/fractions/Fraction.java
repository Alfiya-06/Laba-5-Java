package fractions;

import java.util.Objects;

public class Fraction implements FractionOperations {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.denominator = 1; // временно
        setDenominator(denominator);
        setNumerator(numerator);
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0");
        }
        if (denominator < 0) {
            this.numerator = -this.numerator;
            denominator = -denominator;
        }
        this.denominator = denominator;
    }

    @Override
    public double getDoubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction f = (Fraction) o;
        return numerator == f.numerator && denominator == f.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}