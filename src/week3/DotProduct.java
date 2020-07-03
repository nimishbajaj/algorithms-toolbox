package src.week3;

import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        Arrays.sort(a);
        Arrays.sort(b);
        long result = 0;
        int i = 0, k = 0;
        for (i = a.length - 1; i >= 0; i--) {
//            System.out.println(a[i] + " " + b[i]);
            result += (long) a[i] * b[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int t = 10;
//        while (t-->0){
//            Random rand = new Random(1);
//            int n = 3;
//            int factor = Integer.MAX_VALUE;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
//                a[i] = rand.nextInt(factor)-factor/2;
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
//                b[i] = rand.nextInt(factor)-factor/2;
        }
//            System.out.println("a: " + Arrays.toString(a));
//            System.out.println("b: " + Arrays.toString(b));
        System.out.println(maxDotProduct(a, b));
//            System.out.println();
//        }
    }
}

