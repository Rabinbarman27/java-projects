package Student_Grading_Book;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("  STUDENT GRADING SYSTEM v1.0   ");
        System.out.println("================================");
        HashMap<String, Student> students = new HashMap<>();
        boolean Grading_insession = true;
        boolean Student_Session = true;
        while (Student_Session) {
            System.out.print("Add student name (or 'done'): ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("done")) {
                Student_Session = false;
                break;
            }
            Student s1 = new Student(name);
            Grading_insession = true;
            while (Grading_insession) {
                try {
                    Grading_insession = s1.addGrade();

                } catch (InvalidGradingException e) {
                    System.out.println("input failed" + e.getMessage());

                }

            }
            students.put(name, s1);
            System.out.println();
            System.out.println("--- GRADE REPORT ---");
            System.out.println(
                    s1.getname() + "  |  " + "Avg:" + s1.CalculateAverage() + "  |  " + "Grade:" + s1.Getletter());
            System.out.println();

        }
        System.out.println("=== FINAL CLASS REPORT ===");
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            Student s = entry.getValue();
            System.out.println(s.getname() + "  |  Avg:" + s.CalculateAverage() + "  |  Grade:" + s.Getletter());
        }
    }
}
