package Student_Grading_System;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    public void validateMarks(int Marks) throws InvalidGradeException {
        if (Marks < 0 || Marks > 100) {
            throw new InvalidGradeException(" Grades must be between 0 and 100. Try again.");
        } else {
            Markslist.add(Marks);
        }
    }

    String Name;

    Student(String Name) {
        this.Name = Name;

    }

    static Scanner sc = new Scanner(System.in);
    private ArrayList<Integer> Markslist = new ArrayList<>();

    public String getname() {
        return Name;
    }

    public Boolean addGrade() throws InvalidGradeException {
        System.out.print("Enter grade for " + getname() + " (or -1 to stop): ");
        String grade = sc.nextLine();

        if (grade.equalsIgnoreCase("stop") || grade.equalsIgnoreCase("-1")) {
            return false;
        } else {

            validateMarks(Integer.parseInt(grade));
            
        }

        return true;
    }

    public double getaverage() {
        double sum = 0;

        for (Integer i : Markslist) {
            sum += i;
        }
        double average = sum / Markslist.size();
        return average;
    }

    public char getGrade() {
        if (getaverage() > 80) {
            return 'A';
        } else if (getaverage() > 60) {
            return 'B';
        } else if (getaverage() > 40) {

            return 'C';
        } else {
            return 'D';
        }

    }

}
