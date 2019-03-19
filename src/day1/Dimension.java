package day1;

public class Dimension {


    private double value;

    public Dimension(double value) throws Exception {
        this.validateDimensions(value);
        this.value = value;
    }


    public void validateDimensions(double value) throws Exception {
        if (value < 0) {
            throw new NegativeInputException("Invalid dimensions");
        }
    }

    public double getValue() {
        return this.value;
    }
}
