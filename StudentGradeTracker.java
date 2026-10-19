import java.util.Scanner;

public class StudentGradeTracker {

    // Display all student details
    static void displayStudents(String[] name, int[] marks) {
        for (int i = 0; i < name.length; i++) {
            System.out.printf("%-25s %d%n", name[i], marks[i]);
        }
    }

    // Find highest marks
    static int highestMarks(int[] marks) {
        int highest = marks[0];

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }

        return highest;
    }

    // Find lowest marks
    static int lowestMarks(int[] marks) {
        int lowest = marks[0];

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }

        return lowest;
    }

    // Calculate average marks
    static double calculateAverage(int[] marks) {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return (double) total / marks.length;
    }

    // Main Funcation
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       STUDENT GRADE TRACKER");
        System.out.println("================================");

        // How much student enter ?
        System.out.print("How many students? ");
        int count = input.nextInt();
        input.nextLine();

        if (count <= 0) {
            System.out.println("Please enter a valid student count.");
            input.close();
            return;
        }

        String[] studentNames = new String[count];
        int[] studentMarks = new int[count];

        // Enter student information
        for (int i = 0; i < count; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter name :: ");
            studentNames[i] = input.nextLine();

            while (true) {
                System.out.print("Enter marks :: ");
                int marks = input.nextInt();

                if (marks >= 0 && marks <= 100) {
                    studentMarks[i] = marks;
                    break;
                }else {

                System.out.println("Invalid marks! Try again.");
                }
            }

            input.nextLine();
        }

        // Display final report
        System.out.println("\n================================");
        System.out.println("          PERFORMANCE SUMMARY");
        System.out.println("================================");
        System.out.printf("%-25s %s%n", "Student Name", "Marks");
        System.out.println("--------------------------------");

        displayStudents(studentNames, studentMarks);

        System.out.println("--------------------------------");
        System.out.printf("Class Average :: %.2f%n",
                calculateAverage(studentMarks));
        System.out.println("Highest Marks :: " + highestMarks(studentMarks));
        System.out.println("Lowest Marks  :: " + lowestMarks(studentMarks));
        System.out.println("================================");

        input.close();
    }
}
