package String_file;
import java.util.Scanner;

class BMICalculator {

    // Method to calculate BMI and status for one person
    public static String[] calculateBMI(double weight, double heightCm) {
        // Convert height from cm to meters
        double heightM = heightCm / 100.0;
        // Formula BMI = weight / (height * height)
        double bmi = weight / (heightM * heightM);

        // Determine BMI status
        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        // Return values as String array
        return new String[]{String.format("%.2f", weight), String.format("%.2f", heightCm),
                String.format("%.2f", bmi), status};
    }

    // Method to compute BMI table for all 10 members
    public static String[][] processBMI(double[][] data) {
        String[][] results = new String[data.length][4]; // weight, height, bmi, status
        for (int i = 0; i < data.length; i++) {
            results[i] = calculateBMI(data[i][0], data[i][1]); // weight = data[i][0], height = data[i][1]
        }
        return results;
    }

    // Method to display results in tabular form
    public static void displayResults(String[][] results) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight(kg)", "Height(cm)", "BMI", "Status");
        for (String[] row : results) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a 2D array: 10 rows, 2 columns (weight, height)
        double[][] members = new double[10][2];

        // Take input for 10 members
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for person " + (i + 1));
            System.out.print("Weight (kg): ");
            members[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            members[i][1] = sc.nextDouble();
        }

        // Process BMI
        String[][] results = processBMI(members);

        // Display results
        displayResults(results);
    }
}
