package day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DimensionTest {
    @Test
    @DisplayName("should assign value if given value is greater than zero")
    void shouldAssignValueIfGivenValueIsValid() throws Exception {
        Dimension dimension = new Dimension(0);
        assertEquals(dimension.getValue(), 0);
    }

    @Test
    @DisplayName("should throw exception if given value less than zero")
    void shouldThrowExceptionIfGivenValueIsInvalid() {
        assertThrows(Exception.class, () -> new Dimension(-3));
    }
}