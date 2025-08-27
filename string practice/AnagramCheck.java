package String_file;
import java.util.Scanner;

class AnagramCheck {

    // Method to check if two strings are anagrams
    public static boolean isAnagram(String str1, String str2) {
        // If lengths differ, not anagram
        if (str1.length() != str2.length()) return false;

        int[] freq1 = new int[256]; // freq array for str1
        int[] freq2 = new int[256]; // freq array for str2

        // Count frequencies for str1
        for (int i = 0; i < str1.length(); i++) {
            freq1[str1.charAt(i)]++;
        }

        // Count frequencies for str2
        for (int i = 0; i < str2.length(); i++) {
            freq2[str2.charAt(i)]++;
        }

        // Compare both frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 2 strings
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        // Check
        boolean result = isAnagram(str1, str2);

        // Display
        if (result) {
            System.out.println("The strings are Anagrams.");
        } else {
            System.out.println("The strings are NOT Anagrams.");
        }
    }
}
