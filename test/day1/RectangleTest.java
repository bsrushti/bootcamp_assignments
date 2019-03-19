package day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    @DisplayName("should throw exception if given height or breadth is less than zero")
    void shouldThrowExceptionForInvalidDimensions() {
        try {
            Dimension length = new Dimension(-2);
            Dimension breadth = new Dimension(3);
            new Rectangle(length, breadth);
            fail("should throw exception for invalid height or breadth");
        } catch (Exception e) {
        }
    }

    @Test
    @DisplayName("should return area if given height or breadth is greater than zero")
    void shouldReturnAreaForValidDimensions() throws Exception {
        Dimension length = new Dimension(2);
        Dimension breadth = new Dimension(3);

        Rectangle rectangle = new Rectangle(length, breadth);
        assertEquals(rectangle.calculateArea(), 6);
    }

    @Test
    @DisplayName("should return area if given height or breadth is zero")
    void shouldReturnAreaAsZeroIfOneDimensionIsZero() throws Exception {
        Dimension length = new Dimension(0);
        Dimension breadth = new Dimension(3);
        Rectangle rectangle = new Rectangle(length, breadth);
        assertEquals(rectangle.calculateArea(), 0);
    }

    @Test
    @DisplayName("should return perimeter as zero if given height and breadth are zero")
    void shouldReturnPerimeterAsZeroIfOneDimensionIsZero() throws Exception {
        Dimension length = new Dimension(0);
        Dimension breadth = new Dimension(0);
        Rectangle rectangle = new Rectangle(length, breadth);
        assertEquals(rectangle.calculatePerimeter(), 0);
    }

    @Test
    @DisplayName("should return perimeter if given height or breadth is greater than zero")
    void shouldReturnPerimeterForValidDimensions() throws Exception {
        Dimension length = new Dimension(2);
        Dimension breadth = new Dimension(3);
        Rectangle rectangle = new Rectangle(length, breadth);
        assertEquals(rectangle.calculatePerimeter(), 10);
    }

}