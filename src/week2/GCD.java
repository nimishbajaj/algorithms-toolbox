package src.week2;

import java.util.*;

public class GCD {
    private static int gcd_naive(int a, int b) {
        int current_gcd = 1;
        for (int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    private static int gcd(int a, int b) {
        // make sure that the arguement of a is always greater than b
        if (b > a) gcd(b, a);
        if (b == 0) return a;
        else {
            return gcd(b, a % b);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

//    int factor = 100000000;
//    for(int i=0;i<100;i++){
//      int x = (int) (Math.random() * factor);
//      int y = (int) (Math.random() * factor);
//      if(gcd(x, y)!=gcd_naive(x,y))
//        System.out.println(x + " " + y + " " + gcd(x, y) + " " + gcd_naive(x,y));
//    }

        System.out.println(gcd(a, b));
    }
}
