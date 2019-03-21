package day4.unit;

import java.math.BigDecimal;
import java.util.Objects;

class Quantity {
    private BigDecimal value;
    private Unit unit;

    Quantity(BigDecimal value, Unit unit){
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return Objects.equals(value, quantity.value) &&
                Objects.equals(unit, quantity.unit);
    }

    boolean compareTo(Quantity quantity) {
        BigDecimal baseUnit = unit.calculateBaseUnit(this.value);
        BigDecimal baseUnitOfQuantity = quantity.unit.calculateBaseUnit(quantity.value);

        return baseUnit.intValue()==(baseUnitOfQuantity.intValue());
    }
}
