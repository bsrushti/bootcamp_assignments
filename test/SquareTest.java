import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    @DisplayName("should throw exception if given side is less than zero")
    void shouldThrowExceptionIfGivenSideIsInvalid() {
        try {
            Dimension side = new Dimension(-5);
            new Square(side);
            fail("Invalid Side");
        } catch (Exception e) {
        }
    }

    @Test
    @DisplayName("should return area if given side is greater than zero")
    void shouldReturnAreaOfSquare() throws Exception {
        Dimension side = new Dimension(5);
        Square square = new Square(side);
        assertEquals(square.getArea(), 25);
    }

    @Test
    @DisplayName("should return perimeter if given side is greater than zero")
    void shouldReturnPerimeterOfSquare() throws Exception {
        Dimension side = new Dimension(5);
        Square square = new Square(side);
        assertEquals(square.getPerimeter(), 20);
    }

}