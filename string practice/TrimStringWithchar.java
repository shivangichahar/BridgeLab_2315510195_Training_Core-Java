package String_file;
import java.util.Scanner;

public class TrimStringWithchar {

    static int[] findTrimIndexes(String str) {
        int start = 0, end = str.length() - 1;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }

        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with leading/trailing spaces: ");
        String input = sc.nextLine();

        int[] indexes = findTrimIndexes(input);
        String customTrimmed = customSubstring(input, indexes[0], indexes[1]);
        String builtInTrimmed = input.trim();
        boolean isSame = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("\nOriginal String: >" + input + "<");
        System.out.println("Custom Trimmed : >" + customTrimmed + "<");
        System.out.println("Built-in Trim  : >" + builtInTrimmed + "<");
        System.out.println("Are both same? " + isSame);

        sc.close();
    }
}
