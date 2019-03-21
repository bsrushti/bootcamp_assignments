package day4.unit;

import java.math.BigDecimal;

class Unit {
    private final BigDecimal ratio;
    static final Unit feet = new Unit(new BigDecimal(12));
    static final Unit inch = new Unit(new BigDecimal(1));
    static final Unit cm = new Unit(new BigDecimal(0.4));
    static final Unit mm = new Unit(new BigDecimal(0.04));

    static final Unit gallon = new Unit(new BigDecimal(3.79));
    static final Unit litre = new Unit(new BigDecimal(1));

    private Unit(BigDecimal ratio) {
        this.ratio = ratio;
    }

    BigDecimal calculateBaseUnit(BigDecimal value) {
        return ratio.multiply(value);
    }
}
