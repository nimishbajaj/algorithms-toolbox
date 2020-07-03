package src.week3;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        // denominations
        if (m <= 0) return 0;
        int[] coins = {10, 5, 1};

        int change = 0;
        int num_coins = 0;
        for (int coin : coins) {
            if (m == 0) break;
            num_coins = m / coin;
            m -= coin * num_coins;
            change += num_coins;
        }
        return change;
    }

    public static void main(String[] args) {
//        while(true){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
//        }
    }
}

