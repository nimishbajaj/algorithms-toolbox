import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
                sum %= 10;
            }

            long new_current = next;
            next = (next + current)%10;
            current = new_current;
        }

        return sum % 10;
    }

    private static long getFibonacciSum(long from, long n) {
        n = n%60;
        if (n == 0)
            return 0;

        long previous = from==0?0:getLastDigit(from-1);
        long current  = from==0?1:getLastDigit(from);
        long sum = current;

        if(from==0) n--;

//        System.out.println(previous + " " + current + " " + sum + " ");

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            sum = (sum + current)%10;
//            System.out.println(current + " " + sum + " ");
        }

//        System.out.println();
        return sum % 10;
    }

    private static long getLastDigit(long n) {
        n = n%60;
        if (n <= 1)
            return Math.max(n,0);
        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
        }
        return current;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        if(from==0) from++;

//        int factor = 10000;
//        for(int i=0;i<10000;i++){
//            int x = (int) (Math.random()*factor);
//            if(x==0) x++;
//            int y = (int) (Math.random()*factor);
//            if(y>=x){
//                if(getFibonacciPartialSumNaive(x,y)!=getFibonacciSum(x,y-x+1)){
//                    System.out.println(x+" "+y);
//                    System.out.println("Actual: " + getFibonacciPartialSumNaive(x,y));
//                    System.out.println("Calculated: " + getFibonacciSum(x,y-x+1));
//                    System.out.println("Last Digit: " + getLastDigit(x));
//                }
//            }
//
//        }
        long result = getFibonacciSum(from, to-from+1);
        System.out.println(result);
    }
}

