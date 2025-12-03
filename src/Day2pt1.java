import java.io.File;
import java.util.Scanner;

public class Day2pt1 {
    public static void main(String[] args) throws Exception {
        File file = new File("day2-test.txt");
        Scanner scanner = new Scanner(file);
        if (!scanner.hasNextLine()) {
            System.out.println(0);
            return;
        }
        String line = scanner.nextLine().trim();

        String[] rangeTok = line.split(",");
        long sum = 0L;

        for (String token : rangeTok) {
            token = token.trim();
            String[] parts = token.split("-");

            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);

            for (long i = start; i < end; i++) {
                if (invalidId(i)) {
                    sum += i;
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean invalidId(long id) {
        String s = Long.toString(id);
        int len = s.length();
        if (len % 2 != 0) return false;
        int half = len/2;
        return s.substring(0, half).equals(s.substring(half));
    }
}