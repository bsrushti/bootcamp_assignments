package day4.unit;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    @Test
    void shouldCreateAQuantityOfUnitInch() {
        assertEquals(new Quantity(new BigDecimal(1),Unit.feet),new Quantity(new BigDecimal(1),Unit.feet));
    }

    @Test
    void shouldReturnTrueForSameQuantity() {
        Quantity quantity1 = new Quantity(new BigDecimal(1), Unit.feet);
        Quantity quantity2 = new Quantity(new BigDecimal(1), Unit.feet);

        assertTrue(quantity1.compareTo(quantity2));
    }


    @Test
    void shouldReturnFalseForDifferentQuantities() {
        Quantity quantity1 = new Quantity(new BigDecimal(1), Unit.feet);
        Quantity quantity2 = new Quantity(new BigDecimal(2), Unit.feet);

        assertFalse(quantity1.compareTo(quantity2));
    }


    @Test
    void shouldReturnFalseForSameAmountOfFeetAndInches() {
        Quantity quantity1 = new Quantity(new BigDecimal(12), Unit.feet);
        Quantity quantity2 = new Quantity(new BigDecimal(1), Unit.inch);

        assertFalse(quantity1.compareTo(quantity2));
    }

    @Test
    void shouldReturnTrueForSameAmountOfFeetAndInches() {
        Quantity quantity1 = new Quantity(new BigDecimal(1), Unit.feet);
        Quantity quantity2 = new Quantity(new BigDecimal(12), Unit.inch);

        assertTrue(quantity1.compareTo(quantity2));
    }

    @Test
    void shouldReturnTrueForSameAmountOfCmAndInches() {
        Quantity quantity1 = new Quantity(new BigDecimal(2), Unit.inch);
        Quantity quantity2 = new Quantity(new BigDecimal(5), Unit.cm);

        assertTrue(quantity1.compareTo(quantity2));
    }
}