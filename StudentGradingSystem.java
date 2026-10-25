package studentgrading;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradingSystem {

    static class Student {
        String name;
        int rollNo;
        int mark1, mark2, mark3;

        Student(String name, int rollNo,
                int mark1, int mark2, int mark3) {
            this.name = name;
            this.rollNo = rollNo;
            this.mark1 = mark1;
            this.mark2 = mark2;
            this.mark3 = mark3;
        }

        int getTotal() {
            return mark1 + mark2 + mark3;
        }

        double getPercentage() {
            return getTotal() / 3.0;
        }

        String getGrade() {
            double percentage = getPercentage();

            if (mark1 < 35 || mark2 < 35 || mark3 < 35) {
                return "Fail";
            } else if (percentage >= 90) {
                return "A+";
            } else if (percentage >= 80) {
                return "A";
            } else if (percentage >= 70) {
                return "B";
            } else if (percentage >= 60) {
                return "C";
            } else if (percentage >= 50) {
                return "D";
            } else {
                return "Pass";
            }
        }

        void display() {
            System.out.println("\n--- Student Report ---");
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNo);
            System.out.println("Subject 1: " + mark1);
            System.out.println("Subject 2: " + mark2);
            System.out.println("Subject 3: " + mark3);
            System.out.println("Total: " + getTotal() + "/300");
            System.out.printf("Percentage: %.2f%%%n", getPercentage());
            System.out.println("Grade: " + getGrade());
        }
    }

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    static int readMark(String subject) {
        int mark;

        while (true) {
            System.out.print("Enter " + subject + " marks (0-100): ");

            if (sc.hasNextInt()) {
                mark = sc.nextInt();

                if (mark >= 0 && mark <= 100) {
                    return mark;
                }
            } else {
                sc.next();
            }

            System.out.println("Invalid input! Enter marks from 0 to 100.");
        }
    }

    static void addStudent() {
        sc.nextLine();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");

        while (!sc.hasNextInt()) {
            System.out.println("Enter a valid roll number.");
            sc.next();
        }

        int rollNo = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.println("Roll number already exists!");
                return;
            }
        }

        int m1 = readMark("Subject 1");
        int m2 = readMark("Subject 2");
        int m3 = readMark("Subject 3");

        Student student = new Student(name, rollNo, m1, m2, m3);
        students.add(student);

        System.out.println("Student record added successfully!");
        student.display();
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== STUDENT RECORD & GRADING SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please enter 1, 2, or 3.");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
