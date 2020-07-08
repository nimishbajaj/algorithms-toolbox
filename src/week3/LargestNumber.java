package src.week3;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here


        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return (y+x).compareTo(x+y);
            }
        });

//        Arrays.sort(a);

        StringBuilder result = new StringBuilder();
        for (String s : a) {
            result.append(s);
        }

//        System.out.println(Arrays.toString(a));

        return result.toString();
//        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

