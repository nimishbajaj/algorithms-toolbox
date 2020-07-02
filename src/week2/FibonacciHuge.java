package src.week2;

import java.util.*;

public class FibonacciHuge {
    private static long pisano_period(long m) {
        long p = 0, c = 1, t;
        for(long i=0;i<=m*m;i++){
            t = c;
            c = (c+p)%m;
            p = t;
            if(p==0 && c==1){
                return i+1;
            }
        }
        return -1;
    }

    private static long getFibonacciHuge(long n, long m){
        if(n<=1)
            return n;

        long pisanoLength = pisano_period(m);
//        System.out.println(pisanoLength);
        n = n%pisanoLength;

//        System.out.println(n);


        return getFibonacciHugeNaive(n, m);
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%m;
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

