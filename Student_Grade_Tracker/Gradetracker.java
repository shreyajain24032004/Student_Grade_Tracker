import java.util.Scanner;

public class Gradetracker {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 1. Implement a one-dimensional array to store grades
    int[] grades = new int[5]; // Initialize with default values (0)

    // 2. Create array using new keyword and initializer lists
    int[] currentGrades = new int[] { 85, 92, 78, 95, 88 }; // Example grades

    // Display initial welcome message and options
    System.out.println("Welcome to the Student Grade Tracker!");

    int choice;
    do {
      // Display current grades
      System.out.println("\nCurrent Grades:");
      for (int grade : currentGrades) {
        System.out.print(grade + " ");
      }
      System.out.println();

      // Display menu options
      
      System.out.println("\nOptions:");
      System.out.println("1. Add a new grade");
      System.out.println("2. Modify an existing grade");
      System.out.println("3. Display current grades");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");

      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          // Add a new grade
          addNewGrade(currentGrades);
          break;
        case 2:
          // Modify an existing grade
          modifyGrade(currentGrades);
          break;
        case 3:
          // Print current grades (already done in the loop)
          break;
        case 4:
          // Exit program
          System.out.println("Exiting the Student Grade Tracker!");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (choice != 4);

    scanner.close();
  }

  // Method to add a new grade to the array
  private static void addNewGrade(int[] grades) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the new grade: ");
    int newGrade = scanner.nextInt();

    // Increase array size if needed
    if (grades.length == 0) {
      grades = new int[1]; // Start with initial capacity
    } else if (grades.length == countNonZeroElements(grades)) {
      int[] newGrades = new int[grades.length * 2]; // Double capacity
      System.arraycopy(grades, 0, newGrades, 0, grades.length);
      grades = newGrades;
    }

    // Find first empty slot and add the grade
    int index = 0;
    while (grades[index] != 0) {
      index++;
    }
    grades[index] = newGrade;

    System.out.println("Grade added successfully!");
  }

  // Method to modify an existing grade
  private static void modifyGrade(int[] grades) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the index of the grade to modify (0-" + (grades.length - 1) + "): ");
    int index = scanner.nextInt();

    if (index < 0 || index >= grades.length) {
      System.out.println("Invalid index. Please try again.");
      return;
    }

    System.out.print("Enter the new grade: ");
    int newGrade = scanner.nextInt();

    grades[index] = newGrade;
    System.out.println("Grade modified successfully!");
  }

  // Helper method to count non-zero elements in an array
  private static int countNonZeroElements(int[] arr) {
    int count = 0;
    for (int element : arr) {
      if (element != 0) {
        count++;
      }
    }
    return count;
  }
}
