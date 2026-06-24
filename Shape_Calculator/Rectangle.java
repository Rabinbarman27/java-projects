package Shape_Calculator;

public class Rectangle extends Shapecalculator {
    double length;
    double breath;

    Rectangle(double length, double breath) {
        this.length = length;
        this.breath = breath;

    }

    @Override
    public double area() {
        return length * breath;
    }

    @Override
    public double parameter() {
        return 2 * (length + breath);
    }

    @Override
    public void addtoShapereport() {
        Shapereport.add("Rectangle  |  Area : " + String.format("%.2f", area()) + "|  parameter : "
                + String.format("%.2f", parameter()));
        areas.add(area());
    }
}
