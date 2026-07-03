package Student_Grading_Book;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    static Scanner sc = new Scanner(System.in);
    String name;

    Student(String name) {
        this.name = name;
    }

    private ArrayList<Integer> grades = new ArrayList<>();

    public String getname() {
        return name;
    }

    public void validategrades(int Marks) throws InvalidGradingException {
        if (Marks < 0 || Marks > 100) {
            throw new InvalidGradingException(" Grades must be between 0 and 100. Try again.");
        } else {
            grades.add(Marks);
        }
    }

    public Boolean addGrade() throws InvalidGradingException {
        System.out.print("Enter grade for " + getname() + " (or -1 to stop): ");
        String grade = sc.nextLine();

        if (grade.equalsIgnoreCase("stop") || grade.equalsIgnoreCase("-1")) {
            return false;
        }

        try {
            int marks = Integer.parseInt(grade);
            validategrades(marks);
        } catch (NumberFormatException e) {
            throw new InvalidGradingException("Please enter a valid number (or -1/stop).");
        }

        return true;
    }

    public double CalculateAverage() {

        double sum = 0;
        for (int f : grades) {
            sum += f;
        }
        double Average = sum / grades.size();
        return Average;
    }

    public char Getletter() {
        if (CalculateAverage() >= 90) {
            return 'A';
        } else if (CalculateAverage() >= 80) {
            return 'B';
        } else if (CalculateAverage() >= 60) {
            return 'C';
        }
        return 'D';
    }
}
