package src.week2;

import java.util.*;

public class LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static long lcm(int a, int b) {
        return ((long) a * b) / gcd(a, b);
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

//    int factor = 10000;
//    for(int i=0;i<100;i++){
//      int x = (int) (Math.random() * factor);
//      int y = (int) (Math.random() * factor);
//      if(lcm(x, y)!=lcm_naive(x,y))
//        System.out.println(x + " " + y + " " + lcm(x, y) + " " + lcm_naive(x,y));
//    }

        System.out.println(lcm(a, b));
    }
}
