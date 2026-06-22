public class triangle extends Shapecalculator {
    double Side;
    double height;

    triangle(double Side, double height) {
        this.Side = Side;
        this.height = height;
    }

    @Override
    public double area() {

        return 0.5 * height * Side;
    }

    @Override
    public double parameter() {

        return Side * 3;
    }

    @Override
    public void addtoShapereport() {
        Shapereport.add("Triangle   |  Area : " + String.format("%.2f",area()) + "|  parameter : " + String.format("%.2f",parameter()));
        areas.add(area());
    }
}
