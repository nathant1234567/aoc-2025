// this took 2 days

import java.io.File;
import java.util.Scanner;

public class Day3pt2 {
    public static void main(String[] args) throws Exception {
        File file = new File("day3-test.txt");
        Scanner scanner = new Scanner(file);
        long result = 0;
        int k = 12;

        while (scanner.hasNextLine()) {
            String current = scanner.nextLine();
            long max = getMax(current, k);
            result += max;
        }

        System.out.println(result);
    }

    private static long getMax(String line, int k) {
        int n = line.length();
        StringBuilder chosen = new StringBuilder();
        int startIndex = 0;

        for (int picked = 0; picked < k; picked++) {
            int remainingToPick = k - picked - 1;
            int endIndex = n - 1 - remainingToPick;

            char bestDigit = '0';
            int bestPos = startIndex;

            for (int i = startIndex; i <= endIndex; i++) {
                char c = line.charAt(i);
                if (c > bestDigit) {
                    bestDigit = c;
                    bestPos = i;
                }
            }
            chosen.append(bestDigit);
            startIndex = bestPos + 1;
        }

        return Long.parseLong(chosen.toString());
    }
}
