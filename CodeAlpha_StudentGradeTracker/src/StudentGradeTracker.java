import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console-based Student Grade Tracker for CodeAlpha Java Programming Task 1.
 */
public class StudentGradeTracker {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("      STUDENT GRADE TRACKER");
        System.out.println("===================================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGradeToStudent();
                    break;
                case 3:
                    showAllStudents();
                    break;
                case 4:
                    showClassSummary();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using Student Grade Tracker.");
                    break;
                default:
                    System.out.println("Please enter a number from 1 to 5.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n1. Add a student");
        System.out.println("2. Add a grade for a student");
        System.out.println("3. Display all students");
        System.out.println("4. Display class summary");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static int readMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a whole number: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static void addStudent() {
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("A name cannot be empty.");
            return;
        }

        students.add(new Student(name));
        System.out.println(name + " was added successfully.");
    }

    private static void addGradeToStudent() {
        if (students.isEmpty()) {
            System.out.println("Add a student before entering grades.");
            return;
        }

        listStudentNames();
        System.out.print("Enter the student number: ");
        int studentNumber = readMenuChoice();
        if (studentNumber < 1 || studentNumber > students.size()) {
            System.out.println("That student number does not exist.");
            return;
        }

        double grade = readGrade();
        Student student = students.get(studentNumber - 1);
        student.addGrade(grade);
        System.out.printf("Added %.2f for %s.%n", grade, student.getName());
    }

    private static double readGrade() {
        while (true) {
            System.out.print("Enter a grade from 0 to 100: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Please enter a number.");
                scanner.next();
                continue;
            }

            double grade = scanner.nextDouble();
            scanner.nextLine();
            if (grade >= 0 && grade <= 100) {
                return grade;
            }
            System.out.println("The grade must be between 0 and 100.");
        }
    }

    private static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students have been added yet.");
            return;
        }

        System.out.println("\n---------------- STUDENT REPORT ----------------");
        System.out.printf("%-4s %-20s %-8s %-9s %-9s %-9s %-6s%n",
                "No.", "Name", "Grades", "Average", "Highest", "Lowest", "Letter");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.printf("%-4d %-20s %-8d %-9.2f %-9.2f %-9.2f %-6s%n",
                    i + 1,
                    student.getName(),
                    student.getGradeCount(),
                    student.getAverage(),
                    student.getHighestGrade(),
                    student.getLowestGrade(),
                    student.getLetterGrade());
        }
    }

    private static void showClassSummary() {
        if (students.isEmpty()) {
            System.out.println("No students have been added yet.");
            return;
        }

        int enteredGrades = 0;
        double total = 0;
        double highest = Double.NEGATIVE_INFINITY;
        double lowest = Double.POSITIVE_INFINITY;

        for (Student student : students) {
            for (double grade : student.getGrades()) {
                enteredGrades++;
                total += grade;
                highest = Math.max(highest, grade);
                lowest = Math.min(lowest, grade);
            }
        }

        System.out.println("\n-------------- CLASS SUMMARY --------------");
        System.out.println("Students: " + students.size());
        System.out.println("Grades entered: " + enteredGrades);
        if (enteredGrades == 0) {
            System.out.println("No grades have been entered yet.");
            return;
        }

        System.out.printf("Class average: %.2f%n", total / enteredGrades);
        System.out.printf("Highest grade: %.2f%n", highest);
        System.out.printf("Lowest grade: %.2f%n", lowest);
    }

    private static void listStudentNames() {
        System.out.println("\nStudents:");
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, students.get(i).getName());
        }
    }
}
