package day2;

class Probability {
    private static final int UPPER_BOUND = 1;
    private static final int LOWER_BOUND = 0;
    private double chance;


    Probability(double probability) throws Exception {
        if (isBeyondLimit(probability)) {
            throw new InvalidProbabilityException("Invalid probability");
        }
        this.chance = probability;
    }

    Probability not() throws Exception {
        return new Probability(UPPER_BOUND - this.chance);
    }

    private boolean isBeyondLimit(double probability) {
        return probability < LOWER_BOUND || probability > UPPER_BOUND;
    }

    Probability and(Probability anotherProbability) throws Exception {
        return new Probability(this.chance * anotherProbability.chance);
    }

    Probability difference(Probability anotherProbability) throws Exception {
        return and(anotherProbability).not();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.chance, chance) == 0;
    }

}
