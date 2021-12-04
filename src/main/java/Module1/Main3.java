package Module1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main3 {

    private static long NextRand(long cur, long a, long b) {
        long mod = 1791791791;
        cur = (cur * a + b) % mod;
        return cur;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int arrNum = Integer.parseInt(scanner.nextLine());
        long[] array = new long[arrNum];

        StringTokenizer streamTokenizer = new StringTokenizer(scanner.nextLine(), " ");

        long cur = Integer.parseInt(streamTokenizer.nextToken());
        long a = Integer.parseInt(streamTokenizer.nextToken());
        long b = Integer.parseInt(streamTokenizer.nextToken());

        for (int j = 0; j < arrNum; j++) {
            array[j] = NextRand(cur, a, b);
            cur = array[j];
        }

        Arrays.stream(array).forEach(System.out::println);


        long max = 0;

        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        int maxIndex2 = 0;
        long max2 = 0;
        for (int i = 0; i < array.length; i++) {

            if (a == 0 && b == 0 && cur == 0) {
                maxIndex = i;
                maxIndex2 = i + 1;
                break;
            }

            if (i != maxIndex) {
                if (array[i] > max2) {
                    max2 = array[i];
                    maxIndex2 = i;
                }
            }
        }

        System.out.print(maxIndex + 1 + " ");

        System.out.println(maxIndex2 + 1);

        scanner.close();
    }
}
