/*
Name: Dipti Kothari
PRN: 23070126040
Batch: A2
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        while (true) {
            System.out.println("\n===== Student Data Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position (Index)"); // Assuming position means index
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Student Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        if (age <= 0) {
                            System.out.println("Invalid age. Please enter a positive number.");
                        } else if (name.trim().isEmpty()) {
                            System.out.println("Student name cannot be empty.");
                        } else {
                            Student newStudent = new Student(id, name, age);
                            studentManager.addStudent(newStudent);
                            System.out.println("Student added successfully.");
                        }
                        break;
                    case 2:
                        try {
                            List<Student> allStudents = studentManager.getAllStudents();
                            if (!allStudents.isEmpty()) {
                                System.out.println("\n--- All Students ---");
                                for (Student student : allStudents) {
                                    System.out.println(student);
                                }
                                System.out.println("--------------------");
                            }
                        } catch (NoStudentsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Enter Student ID to search: ");
                        int searchId = sc.nextInt();
                        sc.nextLine();
                        try {
                            Student foundStudent = studentManager.searchStudent(searchId);
                            System.out.println("Student found: " + foundStudent);
                        } catch (StudentNotFoundException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for ID. Please enter a number.");
                            sc.nextLine();
                        }
                        break;
                    case 4:
                        System.out.print("Enter Student Name to search: ");
                        String searchName = sc.nextLine();
                        List<Student> foundStudentsByName = studentManager.searchStudentByName(searchName);
                        if (!foundStudentsByName.isEmpty()) {
                            System.out.println("\n--- Students Found with Name '" + searchName + "' ---");
                            for (Student student : foundStudentsByName) {
                                System.out.println(student);
                            }
                            System.out.println("--------------------------------------------------");
                        } else {
                            System.out.println("No students found with the name: " + searchName);
                        }
                        break;
                    case 5:
                        System.out.print("Enter position (index) to search: ");
                        try {
                            int position = sc.nextInt();
                            sc.nextLine();
                            Student foundStudentByPosition = studentManager.searchStudentByPosition(position);
                            System.out.println("Student at position " + position + ": " + foundStudentByPosition);
                        } catch (StudentNotFoundException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for position. Please enter a number.");
                            sc.nextLine();
                        }
                        break;
                    case 6:
                        System.out.print("Enter Student ID to update: ");
                        try {
                            int updateId = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter new age: ");
                            int newAge = sc.nextInt();
                            sc.nextLine();
                            if (newAge <= 0) {
                                System.out.println("Invalid age. Please enter a positive number.");
                            } else if (newName.trim().isEmpty()) {
                                System.out.println("Student name cannot be empty.");
                            } else {
                                studentManager.updateStudent(updateId, newName, newAge);
                            }
                        } catch (StudentNotFoundException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid ID and age.");
                            sc.nextLine();
                        }
                        break;
                    case 7:
                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();
                        try {
                            studentManager.deleteStudent(deleteId);
                            System.out.println("Student with ID " + deleteId + " deleted successfully.");
                        } catch (StudentNotFoundException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for ID. Please enter a number.");
                            sc.nextLine();
                        }
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (DuplicateStudentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for the menu choice.");
                sc.nextLine(); // Clear the invalid input
            }
        }
    }
}