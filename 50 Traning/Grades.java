import java.util.Scanner;
import java.io.*;
public class Grades {

     int sub1, sub2, sub3, total;
     float avg;
     String grade;

    public Grades(int sub1, int sub2, int sub3) {
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
    }

    public void findTotal() {
        total = sub1 + sub2 + sub3;
    }

    public void findAvg() {
        avg = (float) (total / 3.0);
    }

    public void setGrade() {
        if (sub1 < 35 || sub2 < 35 || sub3 < 35) {
            grade = "Fail";
        } else if (avg >= 70) {
            grade = "A";
        } else if (avg >= 60) {
            grade = "B";
        } else if (avg >= 50) {
            grade = "C";
        } else {
            grade = "Fail";
        }
    }

    public void displayResult() {
        System.out.println("Subject 1: " + sub1);
        System.out.println("Subject 2: " + sub2);
        System.out.println("Subject 3: " + sub3);
        System.out.println("Total: " + total);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + grade);
    }

    public static int checkMarks(Scanner scanner, String subN) {
        int marks;
        while (true) {
            System.out.print("Enter marks for " + subN + " (0-100): ");
            marks = scanner.nextInt();
            if (marks >= 0 && marks <= 100) {
                break;
            }
            System.out.println("Invalid input. enter marks between 0-100");
        }
        return marks;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sub1 = checkMarks(scanner, "Subject 1");
        int sub2 = checkMarks(scanner, "Subject 2");
        int sub3 = checkMarks(scanner, "Subject 3");
        Grades student = new Grades(sub1, sub2, sub3);
        student.findTotal();
        student.findAvg();
        student.setGrade();
        student.displayResult();
    }
}
