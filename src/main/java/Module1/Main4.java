package Module1;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main4 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer streamTokenizer = new StringTokenizer(scanner.nextLine(), " ");

        int arrNum = Integer.parseInt(streamTokenizer.nextToken());

        int[] a = new int[5];
        int[] partSum = new int[5];

        int numberQuery = Integer.parseInt(streamTokenizer.nextToken());

        StringTokenizer tokenForArray = new StringTokenizer(scanner.nextLine(), " ");

        for (int j = 0; j < arrNum; j++) {
            a[j] = Integer.parseInt(tokenForArray.nextToken());
        }

        // метод частичных сумм: в partSum засовываем сумму предыдущего значения и нынешнего
        // и получаем в массиве partSum сумму двух элементов
        partSum[0] = 0;
        for (int i = 1; i <= arrNum; i++) {
            partSum[i] = partSum[i - 1] + a[i-1];
        }

        /*
        int a = 2;
        int b = 7;
        int sum = 0;
        for(int i = 0; i < array.length; i++)
            if (a <= array[i] && array[i] <= b)
                sum +=  array[i];
        System.out.println("Sum: " + sum);
         */


        int res = 0;
        for (int i = 0; i < numberQuery; i++) {
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), " ");

            int left = Integer.parseInt(tokenizer.nextToken());
            int right = Integer.parseInt(tokenizer.nextToken());

            res = partSum[right] - partSum[left - 1];
            System.out.println(res);
        }


    }
}
