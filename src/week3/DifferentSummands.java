package src.week3;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here

        // the minimum that is feasible here is that the numbers should be in the form n(n+1)/2
        int next = 1;
        while (n >= next) {
            n -= next;
            summands.add(next++);
        }
        if (n > 0) {
            summands.add(summands.remove(summands.size() - 1) + n);
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

