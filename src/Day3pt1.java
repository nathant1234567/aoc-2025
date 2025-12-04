// obviously this is extremely inefficient check out the other solution did later in the other file

import java.io.File;
import java.util.Scanner;

public class Day3pt1 {
    public static void main(String[] args) throws Exception {
        File file = new File("day3-test.txt");
        Scanner scanner = new Scanner(file);
        int result = 0;

        while (scanner.hasNextLine()) {
            int currentMax = 0;
            String current = scanner.nextLine();
            int length = current.length();

            for (int i = 0; i < length; i++) {
                int first = Integer.parseInt(String.valueOf(current.charAt(i)));
                for (int j = i + 1; j < length; j++) {
                    int second = Integer.parseInt(String.valueOf(current.charAt(j)));
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