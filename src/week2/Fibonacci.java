package src.week2;

import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        long a = 0;
        long b = 1;
        long temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

//        for (int i = 1; i <= 100; i++)
//            System.out.println(i + " " + calc_fib(i));

        System.out.println(calc_fib(n));
    }
}
