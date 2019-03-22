package day4.unit;

import com.sun.jdi.InvalidTypeException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    @Test
    void shouldCreateAQuantityOfUnitInch() {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.FEET);
        Quantity anotherOneFeet = new Quantity(new BigDecimal(1), Unit.FEET);

        assertEquals(oneFeet, anotherOneFeet);
    }

    @Test
    void shouldReturnTrueForSameQuantity() {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.FEET);
        Quantity anotherOneFeet = new Quantity(new BigDecimal(1), Unit.FEET);

        assertEquals(oneFeet, anotherOneFeet);
    }


    @Test
    void shouldReturnFalseForDifferentQuantities() {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.FEET);
        Quantity twoFeet = new Quantity(new BigDecimal(2), Unit.FEET);

        assertNotEquals(oneFeet, twoFeet);
    }


    @Test
    void shouldReturnFalseForSameAmountOfFeetAndInches() {
        Quantity twelveFeet = new Quantity(new BigDecimal(12), Unit.FEET);
        Quantity oneInch = new Quantity(new BigDecimal(1), Unit.INCH);

        assertNotEquals(twelveFeet, oneInch);
    }

    @Test
    void shouldReturnTrueForSameAmountOfFeetAndInches() {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.FEET);
        Quantity twelveInch = new Quantity(new BigDecimal(12), Unit.INCH);

        assertEquals(oneFeet, twelveInch);
    }

    @Test
    void shouldReturnTrueForSameAmountOfCmAndInches() {
        Quantity twoInch = new Quantity(new BigDecimal(2), Unit.INCH);
        Quantity fiveCm = new Quantity(new BigDecimal(5), Unit.CM);

        assertEquals(twoInch, fiveCm);
    }

    @Test
    void shouldReturnTrueForSameAmountOfCmAndMm() {
        Quantity tenMm = new Quantity(new BigDecimal(10), Unit.MM);
        Quantity oneCm = new Quantity(new BigDecimal(1), Unit.CM);

        assertEquals(tenMm, oneCm);
    }

    @Test
    void shouldReturnTrueForSameAmountOfGallon() {
        Quantity oneGallon = new Quantity(new BigDecimal(1), Unit.GALLON);
        Quantity anotherOneGallon = new Quantity(new BigDecimal(1), Unit.GALLON);

        assertEquals(oneGallon, anotherOneGallon);
    }

    @Test
    void shouldReturnTrueForSameAmountOfGallonAndLitre() {
        Quantity oneGallon = new Quantity(new BigDecimal(1), Unit.GALLON);
        Quantity threePointSevenNineLitre = new Quantity(new BigDecimal(3.79), Unit.LITRE);

        assertEquals(oneGallon, threePointSevenNineLitre);
    }

    @Test
    void shouldReturnFalseForDifferentAmountOfGallonAndLitre() {
        Quantity oneGallon = new Quantity(new BigDecimal(1), Unit.GALLON);
        Quantity fourLitres = new Quantity(new BigDecimal(4), Unit.LITRE);

        assertNotEquals(oneGallon, fourLitres);
    }

    @Test
    void shouldReturnAdditionOfTwoFeetQuantities() throws InvalidTypeException {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.FEET);
        Quantity expectedSum = new Quantity(new BigDecimal(2), Unit.FEET);

        assertEquals(expectedSum,oneFeet.add(oneFeet));
    }

    @Test
    void shouldReturnAdditionOfTwoInchAndTwoPointFiveCmInInches() throws InvalidTypeException {
        Quantity twoInch = new Quantity(new BigDecimal(2), Unit.INCH);
        Quantity twoPointFiveCm = new Quantity(new BigDecimal(2.5), Unit.CM);

        Quantity expectedSum = new Quantity(new BigDecimal(3), Unit.INCH);
        assertEquals(expectedSum,twoInch.add(twoPointFiveCm));
    }

    @Test
    void shouldReturnAdditionOfOneGallonAndOneLitreInLitres() throws InvalidTypeException {
        Quantity oneLitre = new Quantity(new BigDecimal(1), Unit.LITRE);
        Quantity oneGallon = new Quantity(new BigDecimal(1), Unit.GALLON);

        Quantity expectedSum = new Quantity(new BigDecimal(4), Unit.LITRE);
        assertEquals(expectedSum,oneLitre.add(oneGallon));
    }
}