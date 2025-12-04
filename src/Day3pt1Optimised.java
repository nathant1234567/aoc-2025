// HAHAH GET RID OF THOSE STUPID NESTED LOOPS

import java.io.File;
import java.util.Scanner;

public class Day3pt1Optimised {
    public static void main(String[] args) throws Exception {
        File file = new File("day3-test.txt");
        Scanner scanner = new Scanner(file);
        int result = 0;

        while (scanner.hasNextLine()) {
            String current = scanner.nextLine();
            int length = current.length();
            int[] rightMax = new int[length];

            int maxDigit = -1;
            for (int i = length - 1; i >= 0; i--) {
                rightMax[i] = maxDigit;
                int digit = current.charAt(i) - '0';
                if (digit > maxDigit) {
                    maxDigit = digit;
                }
            }
            int currentMax = 0;

            for (int i = 0; i < length - 1; i++) {
                int first = current.charAt(i) - '0';
                int second = rightMax[i];

                if (second >= 0) {
                    int value = first * 10 + second;
                    if (value > currentMax) {
                        currentMax = value;
                    }
                }
            }
            result += currentMax;
        }
        System.out.println(result);
    }
}