package day9.bag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BagTest {

    @Test
    void shouldReturnTrueOnAddingOfBall() {
        Bag bag = new Bag(12);
        Ball redBall = new Ball("red");
        assertTrue(bag.addBall(redBall));
    }
}