import java.util.Objects;

public class Fraction implements FractionOperations {
    private int numerator;
    private int denominator;
    private Double cachedValue;

    public Fraction(int numerator, int denominator) {
        setFraction(numerator, denominator);
    }

    private void setFraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Знаменатель не может быть 0");
        // переносим знак в числитель
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        this.cachedValue = null;
    }

    @Override
    public void setNumerator(int numerator) {
        setFraction(numerator, this.denominator);
    }

    @Override
    public void setDenominator(int denominator) {
        setFraction(this.numerator, denominator);
    }

    @Override
    public double getDoubleValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
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