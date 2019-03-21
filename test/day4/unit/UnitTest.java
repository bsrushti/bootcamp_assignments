package day4.unit;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void shouldGetSameFeetUnit() {
        assertEquals(Unit.FEET,Unit.FEET);
    }

    @Test
    void shouldGetSameInchUnit() {
        assertEquals(Unit.INCH,Unit.INCH);
    }

    @Test
    void shouldConvertFeetToBaseUnit() {
        assertEquals(new BigDecimal(12),Unit.FEET.calculateBaseUnit(new BigDecimal(1)));
    }
}