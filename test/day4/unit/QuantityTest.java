package day4.unit;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    @Test
    void shouldCreateAQuantityOfUnitInch() {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.feet);
        Quantity anotherOneFeet = new Quantity(new BigDecimal(1), Unit.feet);
        assertEquals(oneFeet,anotherOneFeet);
    }

    @Test
    void shouldReturnTrueForSameQuantity() {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.feet);
        Quantity anotherOneFeet = new Quantity(new BigDecimal(1), Unit.feet);

        assertEquals(oneFeet,anotherOneFeet);
    }


    @Test
    void shouldReturnFalseForDifferentQuantities() {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.feet);
        Quantity twoFeet = new Quantity(new BigDecimal(2), Unit.feet);

        assertNotEquals(oneFeet,twoFeet);
    }


    @Test
    void shouldReturnFalseForSameAmountOfFeetAndInches() {
        Quantity twelveFeet = new Quantity(new BigDecimal(12), Unit.feet);
        Quantity oneInch = new Quantity(new BigDecimal(1), Unit.inch);

        assertNotEquals(twelveFeet,oneInch);
    }

    @Test
    void shouldReturnTrueForSameAmountOfFeetAndInches() {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.feet);
        Quantity twelveInch = new Quantity(new BigDecimal(12), Unit.inch);

        assertEquals(oneFeet,twelveInch);
    }

    @Test
    void shouldReturnTrueForSameAmountOfCmAndInches() {
        Quantity twoInch = new Quantity(new BigDecimal(2), Unit.inch);
        Quantity fiveCm = new Quantity(new BigDecimal(5), Unit.cm);

        assertEquals(twoInch,fiveCm);
    }

    @Test
    void shouldReturnTrueForSameAmountOfCmAndMm() {
        Quantity tenMm = new Quantity(new BigDecimal(10), Unit.mm);
        Quantity oneCm = new Quantity(new BigDecimal(1), Unit.cm);

        assertEquals(tenMm,oneCm);
    }
}