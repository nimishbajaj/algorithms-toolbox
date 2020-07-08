package src.week5;

import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] coins = {1, 3, 4};
        for (int i = 1; i <= m; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

