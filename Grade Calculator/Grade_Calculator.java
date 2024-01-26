package Task_2;

import java.util.Scanner;

public class Grade_calculator 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter marks (out of 100) for each subject:");
        int subjectCount = 5; 
        int[] marks = new int[subjectCount];
        
        for (int i = 0; i < subjectCount; i++) 
        {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, subjectCount);
        char grade = calculateGrade(averagePercentage);
        displayResults(totalMarks, averagePercentage, grade);
    }

    static int calculateTotalMarks(int[] marks) 
    {
        int total = 0;
        for (int mark : marks) 
        {
            total += mark;
        }
        return total;
    }

    static double calculateAveragePercentage(int totalMarks, int subjectCount) 
    {
        return (double) totalMarks / subjectCount;
    }

    static char calculateGrade(double averagePercentage) 
    {
        if (averagePercentage >= 90) 
        {
            return 'A';
        } else if (averagePercentage >= 80) 
        {
            return 'B';
        } else if (averagePercentage >= 70) 
        {
            return 'C';
        } else if (averagePercentage >= 60) 
        {
            return 'D';
        } else 
        {
            return 'F';
        }
    }

    static void displayResults(int totalMarks, double averagePercentage, char grade) 
    {
        
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}