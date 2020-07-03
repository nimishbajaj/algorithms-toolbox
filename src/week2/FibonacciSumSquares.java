package src.week2;

import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
            sum = (sum + current * current) % 10;
        }

        return sum % 10;
    }

    private static long getFibonacciSumSquares(long n) {
        n %= 30;
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

//        System.out.print(previous + " " +  current + " ");

        for (long i = 2; i <= n; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
            sum = (sum + current * current) % 10;
//            System.out.print(sum + " ");
        }

        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquares(n);
        System.out.println(s);

//        for(int i=0;i<10000;i++){
//            if(getFibonacciSumSquaresNaive(i)!=getFibonacciSumSquares(i)){
//                System.out.println(i);
//                System.out.println("Actual: " + getFibonacciSumSquaresNaive(i));
//                System.out.println("Calculated: " + getFibonacciSumSquares(i));
//            }
//        }
    }
}

