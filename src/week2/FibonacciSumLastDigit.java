package src.week2;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            sum = (sum + current)%10;
        }

        return sum % 10;
    }


    private static long getFibonacciSum(long n) {
        n = n%60;
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            sum = (sum + current)%10;
//            System.out.print(sum%10 + " ");
        }

        return sum % 10;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
//        for(int i=0;i<=1000;i++){
//            if(getFibonacciSum(i)!=getFibonacciSumNaive(i)){
//                System.out.println(i);
//            }
//        }
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

