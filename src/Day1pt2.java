// a bit more optimisation here :)

import java.io.File;
import java.util.Scanner;

public class Day1pt2 {

    public static void main(String[] args) throws Exception {
        File file = new File("day1-test.txt");
        Scanner scanner = new Scanner(file);

        int current = 50;
        long password = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char dir = line.charAt(0);
            int amount = Integer.parseInt(line.substring(1));

            if (dir == 'R') {
                password += (current + amount) / 100;

                current = (current + amount) % 100;

            } else {
                int forward = (100 - current) % 100;

                password += (forward + amount) / 100;

                current = (current - amount) % 100;
                if (current < 0) current += 100;
            }
        }

        System.out.println(password);
    }
}
