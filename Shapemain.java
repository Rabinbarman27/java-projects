import java.util.Scanner;

public class Shapemain {
    static String Shape;
    static boolean session = true;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("    SHAPE CALCULATOR v1.0    ");
        System.out.println("================================");
        while (session) {
            System.out.print("Add a shape (circle/rectangle/triangle/done): ");
            Shape = sc.nextLine();
            if (Shape.equalsIgnoreCase("Circle")) {
                System.out.print("Enter radius: ");
                double length = sc.nextDouble();
                sc.nextLine();
                Circle c1 = new Circle(length);
                c1.area();
                c1.parameter();
                c1.addtoShapereport();
            } else if (Shape.equalsIgnoreCase("Rectangle")) {
                System.out.print("Enter length: ");
                double length = sc.nextDouble();
                System.out.print("Enter breath: ");
                double breath = sc.nextDouble();
                sc.nextLine();
                Rectangle R1 = new Rectangle(length, breath);
                R1.area();
                R1.parameter();
                R1.addtoShapereport();
            } else if (Shape.equalsIgnoreCase("triangle")) {
                System.out.print("Enter length: ");
                double length = sc.nextDouble();
                System.out.print("Enter height: ");
                double height = sc.nextDouble();
                sc.nextLine();
                triangle t1 = new triangle(length, height);
                t1.area();
                t1.parameter();
                t1.addtoShapereport();
            } else {
                session = false;
            }
        }
        System.out.println();
        System.out.println("--- SHAPE REPORT ---");
        System.out.println();
        for (String S : Shapecalculator.Shapereport) {
            System.out.println(S);
        }
        
    }
}
