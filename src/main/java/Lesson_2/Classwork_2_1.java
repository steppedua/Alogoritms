package Lesson_2;

import java.util.*;

class InetAddressMain {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("abcaded");
        System.out.println(a.reverse());

        String d = "abcaded";
        char[] chars = d.toCharArray();

        Set<Character> set = new TreeSet<>();

        for (char aChar : chars) {
            set.add(aChar);
        }


        set.forEach(System.out::println);


    }


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);

        //№1
        //[1,[1, 2,[3, 4]], [2, 4]] ->[1, 1, 2, 3, 4, 2, 4]


//        вложенные подмассивы java
//        int[][] arr = {{1}, {1, 2, {3, 4}}, {2, 4}};


        //№2
        //dog -> dgo -> true
        //dog -> dfo -> false
        //doog -> ddog -> false

        System.out.println(isTestMethodString("dog", "dgo"));
        System.out.println(isTestMethodString("dog", "dfo"));
        System.out.println(isTestMethodString("doog", "ddog"));

//        Arrays.stream(arr).map().forEach(System.out::println);
    }

    public static boolean isTestMethodString(String s1, String s2) {

        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        String sortedArr1 = new String(arr1);

        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        String sortedArr2 = new String(arr2);


        if (sortedArr1.equals(sortedArr2)) {
            return true;
        }

        return false;
    }
}
