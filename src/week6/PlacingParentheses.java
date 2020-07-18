package src.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();

        for (String str : exp.split("[-|\\+|\\*]")) {
            nums.add(Long.parseLong(str));
        }

        for (String str : exp.split("[0-9]*")) {
            if (str.equals("+") || str.equals("-") || str.equals("*")) {
                ops.add(str.charAt(0));
            }
        }
        int n = nums.size();
        long[][] M = new long[n][n];
        long[][] m = new long[n][n];

//        System.out.println(nums + " " + nums.size());
//        System.out.println(ops + " " + ops.size());

        for (int i = 0; i < n; i++) {
            m[i][i] = nums.get(i);
            M[i][i] = nums.get(i);
        }

        for (int s = 1; s < n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                long[] minMax = minMaxValue(i, j, M, m, ops);
                m[i][j] = minMax[0];
                M[i][j] = minMax[1];
            }
        }

//        for(long[] a: m) System.out.println(Arrays.toString(a));
//        for(long[] a: M) System.out.println(Arrays.toString(a));

        return M[0][n - 1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }

    private static long[] minMaxValue(int i, int j, long[][] M, long[][] m, ArrayList<Character> ops) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int k = i; k < j; k++) {
            long a = eval(M[i][k], M[k + 1][j], ops.get(k));
            long b = eval(M[i][k], m[k + 1][j], ops.get(k));
            long c = eval(m[i][k], M[k + 1][j], ops.get(k));
            long d = eval(m[i][k], m[k + 1][j], ops.get(k));

            min = Collections.min(Arrays.asList(min, a, b, c, d));
            max = Collections.max(Arrays.asList(max, a, b, c, d));
        }

        return new long[]{min, max};
    }
}

