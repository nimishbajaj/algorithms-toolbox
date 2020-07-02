package src.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    static class Item {
        int weight;
        int value;
        double vtow;

        public Item(int weight, int value, double vtow) {
            this.weight = weight;
            this.value = value;
            this.vtow = vtow;
        }
    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        Item[] items = sortedItems(weights, values);

        for(Item item: items){
            if(capacity==0) break;
            int amount = Math.min(item.weight, capacity);
            value += amount*item.vtow;
            capacity -= amount;
        }

        return value;
    }

    private static Item[] sortedItems(int[] weights, int[] values) {
        Item[] items = new Item[weights.length];
        for(int i=0;i<weights.length;i++){
            items[i] = new Item(weights[i], values[i], (double)values[i]/weights[i]);
        }
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Double.compare(item2.vtow, item1.vtow);
            }
        });

        return items;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%3f",getOptimalValue(capacity, values, weights));
    }
} 
