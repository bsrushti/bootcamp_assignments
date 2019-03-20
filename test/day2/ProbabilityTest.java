package day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    void shouldAcceptValidProbability() {
        assertDoesNotThrow(() -> new Probability(0.5));
    }

    @Test
    void shouldThrowExceptionForProbabilityLessThanZero() {
        assertThrows(Exception.class, () -> new Probability(-5));
    }

    @Test
    void shouldThrowExceptionForProbabilityGreaterThanZero() {
        assertThrows(Exception.class, () -> new Probability(5));
    }

    @Test
    void shouldReturnProbabilityOfNotGettingChance() throws Exception {
        Probability probability = new Probability(0.5);
        Probability expected = new Probability(0.5);
        assertEquals(expected, probability.not());
    }

    @Test
    void shouldReturnTotalProbability() throws Exception {
        Probability coinOneProbability = new Probability(0.5);
        Probability coinTwoProbability = new Probability(0.5);
        Probability expected = new Probability(0.25);
        assertEquals(expected,coinOneProbability.and(coinTwoProbability));
    }

    @Test
    void shouldReturnOrOfProbabilities() throws Exception {
        Probability coinOneProbability = new Probability(0.5);
        Probability coinTwoProbability = new Probability(0.5);
        Probability expected = new Probability(0.75);
        assertEquals(expected,coinOneProbability.or(coinTwoProbability));
    }
}