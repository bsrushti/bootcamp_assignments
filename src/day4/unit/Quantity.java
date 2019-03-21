package day4.unit;

import java.math.BigDecimal;

class Quantity {
    private BigDecimal value;
    private Unit unit;

    Quantity(BigDecimal value, Unit unit){
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object otherQuantity) {
        Quantity quantity = (Quantity) otherQuantity;
        BigDecimal baseUnit = unit.calculateBaseUnit(this.value);
        BigDecimal baseUnitOfQuantity = quantity.unit.calculateBaseUnit(quantity.value);

        return baseUnit.intValue()==(baseUnitOfQuantity.intValue());
    }
}
