import java.util.ArrayList;

abstract public class Shapecalculator {
    abstract double area();

    abstract double parameter();

    abstract void addtoShapereport();

    static ArrayList<String> Shapereport = new ArrayList<>();
    static int total_Shapes=0;
    static ArrayList<Double> areas= new ArrayList<>();
    
    
}
