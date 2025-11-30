package fractions;

public class CachedFraction implements FractionOperations {
    private final FractionOperations fraction;
    private Double cachedValue = null;

    public CachedFraction(FractionOperations fraction) {
        this.fraction = fraction;
    }

    @Override
    public double getDoubleValue() {
        if (cachedValue == null) {
            cachedValue = fraction.getDoubleValue();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        cachedValue = null; // сброс кэша
    }

    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        cachedValue = null; // сброс кэша
    }

    @Override
    public String toString() {
        return fraction.toString() + " = " + getDoubleValue();
    }
}