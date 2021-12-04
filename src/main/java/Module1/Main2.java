package Module1;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int arrNum = Integer.parseInt(scanner.nextLine());
        int[] array = new int[arrNum];

        StringTokenizer streamTokenizer = new StringTokenizer(scanner.nextLine(), " ");

        for (int j = 0; j < arrNum; j++) {
            array[j] = Integer.parseInt(streamTokenizer.nextToken());
        }


        int max = 0;

        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        int maxIndex2 = 0;
        int max2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != maxIndex) {
                if (array[i] > max2) {
                    max2 = array[i];
                    maxIndex2 = i;
                }
            }
        }

        System.out.println(maxIndex + 1);

        System.out.println(maxIndex2 + 1);

        scanner.close();
    }
}