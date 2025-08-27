package String_file;
import java.util.Random;

public class Doc2 {
    
    // Method to generate random 2-digit scores for Physics, Chemistry and Math (PCM)
    public static int[][] generateRandomScores(int numStudents) {
        Random random = new Random();
        int[][] scores = new int[numStudents][3]; // 3 subjects: Physics, Chemistry, Math
        
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = random.nextInt(90) + 10; // Random scores between 10-99
            }
        }
        return scores;
    }
    
    // Method to calculate total, average, and percentages for each student
    public static double[][] calculateStats(int[][] scores) {
        int numStudents = scores.length;
        double[][] stats = new double[numStudents][4]; // total, average, percentage, grade
        
        for (int i = 0; i < numStudents; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += scores[i][j];
            }
            
            double average = Math.round((total / 3.0) * 100.0) / 100.0; // Round to 2 decimal places
            double percentage = Math.round(((total / 300.0) * 100) * 100.0) / 100.0; // Round to 2 decimal places
            
            stats[i][0] = total;
            stats[i][1] = average;
            stats[i][2] = percentage;
            stats[i][3] = calculateGrade(percentage); // Store grade as numeric value
        }
        return stats;
    }
    
    // Method to calculate grade based on percentage
    public static int calculateGrade(double percentage) {
        if (percentage >= 80) return 1; // A
        else if (percentage >= 70) return 2; // B
        else if (percentage >= 60) return 3; // C
        else if (percentage >= 50) return 4; // D
        else if (percentage >= 40) return 5; // E
        else return 6; // F
    }
    
    // Method to get grade character
    public static char getGradeChar(int gradeNum) {
        switch(gradeNum) {
            case 1: return 'A';
            case 2: return 'B';
            case 3: return 'C';
            case 4: return 'D';
            case 5: return 'E';
            default: return 'F';
        }
    }
    
    // Method to get grade description
    public static String getGradeDescription(int gradeNum) {
        switch(gradeNum) {
            case 1: return "Level 4, above agency-normalized standards";
            case 2: return "Level 3, at agency-normalized standards";
            case 3: return "Level 2, below, but approaching agency-normalized standards";
            case 4: return "Level 1, well below agency-normalized standards";
            case 5: return "Level 1-, too below agency-normalized standards";
            default: return "Remedial standards";
        }
    }
    
    // Method to display scorecard in tabular format
    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("\n=== STUDENT SCORECARD ===");
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade\tRemarks");
        System.out.println("-----------------------------------------------------------------------------------------");
        
        for (int i = 0; i < scores.length; i++) {
            char grade = getGradeChar((int)stats[i][3]);
            String remarks = getGradeDescription((int)stats[i][3]);
            
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t\t%.2f%%\t\t%c\t%s%n",
                (i + 1), scores[i][0], scores[i][1], scores[i][2],
                stats[i][0], stats[i][1], stats[i][2], grade, remarks);
        }
    }
    
    public static void main(String[] args) {
        int numStudents = 5; // You can change this number
        
        // Generate random scores for students
        int[][] studentScores = generateRandomScores(numStudents);
        
        // Calculate statistics
        double[][] studentStats = calculateStats(studentScores);
        
        // Display the scorecard
        displayScorecard(studentScores, studentStats);
    }
}