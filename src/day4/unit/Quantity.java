package day4.unit;

import com.sun.jdi.InvalidTypeException;

import java.math.BigDecimal;

class Quantity {
    private BigDecimal value;
    private Unit unit;

    Quantity(BigDecimal value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object otherQuantity) {
        if (!(otherQuantity instanceof Quantity)) {
            return false;
        }
        Quantity quantity = (Quantity) otherQuantity;
        BigDecimal baseUnit = unit.calculateBaseUnit(this.value);
        BigDecimal baseUnitOfQuantity = quantity.unit.calculateBaseUnit(quantity.value);

        return baseUnit.intValue() == (baseUnitOfQuantity.intValue());
    }

    Quantity add(Quantity anotherQuantity) throws InvalidTypeException {
        if(!(this.unit.isEqual(anotherQuantity.unit))) {
            throw new InvalidTypeException("invalid types");
        }

        BigDecimal firstQuantityInInch = unit.calculateBaseUnit(this.value);
        BigDecimal secondQuantityInInch = anotherQuantity.unit.calculateBaseUnit(anotherQuantity.value);
        int sum = firstQuantityInInch.add(secondQuantityInInch).intValue();
        BigDecimal sumInFirstUnit =  this.unit.convertTo(new BigDecimal(sum));
        return new Quantity(sumInFirstUnit,this.unit);
    }
}
