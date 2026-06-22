public class Circle extends Shapecalculator {
    double radious;

    Circle(double radious) {
        this.radious = radious;
    }

    @Override

    public double area() {

        return Math.PI * radious * radious;
    }

    @Override
    public double parameter() {

        return 2 * Math.PI * radious ;
    }

    @Override
    public void addtoShapereport() {
        Shapereport.add("Circle     |  Area : " + String.format("%.2f",area()) + "|  parameter : " + String.format("%.2f",parameter()));



    }

}