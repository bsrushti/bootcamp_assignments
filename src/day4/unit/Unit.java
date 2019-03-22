package day4.unit;

import java.math.BigDecimal;

class Unit {
    private final BigDecimal ratio;
    private final Object type;

    private static final Object LENGTH = new Object();
    private static final Object VOLUME = new Object();

    static final Unit FEET = new Unit(new BigDecimal(12),LENGTH);
    static final Unit INCH = new Unit(new BigDecimal(1),LENGTH);
    static final Unit CM = new Unit(new BigDecimal(0.4),LENGTH);
    static final Unit MM = new Unit(new BigDecimal(0.04),LENGTH);

    static final Unit GALLON = new Unit(new BigDecimal(3.79),VOLUME);
    static final Unit LITRE = new Unit(new BigDecimal(1),VOLUME);

    private Unit(BigDecimal ratio, Object type) {
        this.ratio = ratio;
        this.type = type;
    }

    BigDecimal calculateBaseUnit(BigDecimal value) {
        BigDecimal convertedValue = ratio.multiply(value);
        return convertedValue;
    }

    boolean isEqual(Unit unit) {
        return this.type == unit.type;
    }

    BigDecimal convertTo(BigDecimal value) {
        return value.divide(ratio);
    }
}
