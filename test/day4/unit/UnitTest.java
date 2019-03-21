package day4.unit;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void shouldGetSameFeetUnit() {
        assertEquals(Unit.feet,Unit.feet);
    }

    @Test
    void shouldGetSameInchUnit() {
        assertEquals(Unit.inch,Unit.inch);
    }

    @Test
    void shouldConvertFeetToBaseUnit() {
        assertEquals(new BigDecimal(12),Unit.feet.calculateBaseUnit(new BigDecimal(1)));
    }
}