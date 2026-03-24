import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    int id;
    String name;
    double marks;

    // Constructor
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Display student details
    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagement {

    static ArrayList<Student> students = new ArrayList<>();

    // Add student
    static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student Added Successfully!\n");
    }

    // Display all students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.\n");
            return;
        }

        System.out.println("\nStudent List:");
        for (Student s : students) {
            s.display();
        }
        System.out.println();
    }

    // Search student by ID
    static void searchStudent(Scanner sc) {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student Found:");
                s.display();
                return;
            }
        }
        System.out.println("Student not found.\n");
    }

    // Calculate average marks
    static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No data available.\n");
            return;
        }

        double sum = 0;
        for (Student s : students) {
            sum += s.marks;
        }

        double avg = sum / students.size();
        System.out.println("Average Marks: " + avg + "\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent(sc);
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }

        } while (choice != 5);

        sc.close();
    }
}
