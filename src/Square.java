public class Square {
    private final Dimension side;

    public Square(Dimension side) {
        this.side = side;
    }

    public double getArea() {
        return this.side.getValue() * this.side.getValue();
    }

    public double getPerimeter() {
        return 4 * this.side.getValue();
    }
}
