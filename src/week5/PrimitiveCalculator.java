package src.week5;

import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 1; i < n; i++) {
            if (i + 1 <= n) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }

            if (i * 2 <= n) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }

            if (i * 3 <= n) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        int t = n;
        while (t != 1) {
            sequence.add(t);
            int min = Integer.MAX_VALUE;
            int tempT = t;
            if (t % 3 == 0 && t / 3 >= 1 && dp[t / 3] < min) {
                min = Math.min(min, dp[t / 3]);
                tempT = t / 3;
            }

            if (t % 2 == 0 && t / 2 >= 1 && dp[t / 2] < min) {
                min = Math.min(min, dp[t / 2]);
                tempT = t / 2;
            }

            if (t - 1 >= 1 && dp[t - 1] < min) {
                min = Math.min(min, dp[t - 1]);
                tempT = t - 1;
            }

            t = tempT;
        }
        sequence.add(1);

        Collections.reverse(sequence);

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

