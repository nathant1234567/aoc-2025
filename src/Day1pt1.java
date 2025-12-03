import java.io.File;
import java.util.Scanner;

public class Day1pt1 {

    public static void main(String[] args) throws Exception {
        File file = new File("day1-test.txt");
        Scanner scanner = new Scanner(file);

        int current = 50;
        int password = 0;

        while (scanner.hasNextLine()) {
            String currentPos = scanner.nextLine();

            if (currentPos.charAt(0) == 'R') {
                System.out.println(currentPos + " from " + current);
                current += Integer.parseInt(currentPos.substring(1));

                current = current % 100;

                if (current == 0) {
                    password++;
                }

            } else {
                System.out.println(currentPos + " from " + current);
                current -= Integer.parseInt(currentPos.substring(1));

                current = current % 100;
                if (current < 0) {
                    current += 100;
                }

                if (current == 0) {
                    password++;
                }
            }
        }

        System.out.println(password);
    }
}
