package Lesson_2;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
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
            if (maxIndex2 != maxIndex) {
                if (array[i] > max2) {
                    max2 = array[i];
                    maxIndex2 = i;
                }
            }
        }


        System.out.println(maxIndex2 + 1);

        scanner.close();


//        for (int j = 0; j < b.length - 1; j++) {
//
//
//        }


//        public static void main2 (String[]args){
//
//            List<Melon> melons = Arrays.asList(
//                    new Melon("Apollo", 3000),
//                    new Melon("Jade Dew", 3500),
//                    new Melon("Cantaloupe", 1500),
//                    new Melon("Gac", 1600),
//                    new Melon("Hami", 1400),
//                    new Melon("Hami", 6000)
//            );
//
//
//            Map<Boolean, List<Melon>> separatedMelons = melons.stream()
//                    .collect(Collectors.partitioningBy((Melon t) -> t.getWeight() >= 3000)
//                    );
//
//            List<Melon> weightLessThan3000 = separatedMelons.get(true);
//            List<Melon> weightGreaterThan3000 = separatedMelons.get(false);
//
//            System.out.println(weightLessThan3000);
//            System.out.println(weightGreaterThan3000);
//
//            boolean allTheSame = Collections.frequency(melons, melons.get(0)) == melons.size();
//            System.out.println(allTheSame);
//        }


        class Melon {
            private String type;
            private int weight;

            public Melon(String type, int weight) {
                this.type = type;
                this.weight = weight;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            @Override
            public String toString() {
                return "Melon{" +
                        "type='" + type + '\'' +
                        ", weight=" + weight +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Melon melon = (Melon) o;
                return weight == melon.weight && Objects.equals(type, melon.type);
            }

            @Override
            public int hashCode() {
                return Objects.hash(type, weight);
            }
        }
    }
}
