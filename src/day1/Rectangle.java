package day1;

public class Rectangle implements Shape {
    private final Dimension length;
    private final Dimension breadth;

    public Rectangle(Dimension length, Dimension breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return this.length.getValue() * this.breadth.getValue();
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (this.length.getValue() + this.breadth.getValue());
    }
}
