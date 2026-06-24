package Student_Grading_System;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("    BANK ACCOUNT SYSTEM v1.0    ");
        System.out.println("================================");
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

                } catch (InvalidGradeException e) {
                    System.err.println("input failed" + e.getMessage());

                }

            }
            System.out.println();
            System.out.println("--- GRADE REPORT ---");
            System.out.println(s1.getname() + "  |  " + "Avg:" + s1.getaverage() + "  |  " + "Grade:" + s1.getGrade());
            System.out.println();

        }
    }

}
