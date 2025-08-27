package String_file;

import java.util.Scanner;

public class Doc1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        String[] grades = new String[n];

        // Input marks for each student
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            sc.nextLine();
            names[i] = sc.nextLine();
            System.out.print("Physics marks: ");
            marks[i][0] = sc.nextInt();
            System.out.print("Chemistry marks: ");
            marks[i][1] = sc.nextInt();
            System.out.print("Math marks: ");
            marks[i][2] = sc.nextInt();

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double percentage = ((total / 300.0) * 100);
            // Round to 2 decimal places
            percentages[i] = Math.round(percentage * 100) / 100.0;

            grades[i] = getGrade(percentages[i]);
        }

        System.out.printf("\n%-10s %-10s %-10s %-10s %-10s %-12s %-6s\n",
                "Student", "Physics", "Chemistry", "Math", "Total", "Percent", "Grade");
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            System.out.printf("%-10s %-10d %-10d %-10d %-10d %-12.2f %-6s\n",
                    names[i], marks[i][0], marks[i][1], marks[i][2], total, percentages[i], grades[i]);
        }
        sc.close();
    }

    public static String getGrade(double pct) {
        if (pct >= 80) return "A";
        if (pct >= 70) return "B";
        if (pct >= 60) return "C";
        if (pct >= 50) return "D";
        if (pct >= 40) return "E";
        return "F";
    }
}
