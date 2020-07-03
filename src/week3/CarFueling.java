package src.week3;

import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        // start from 0, go to the last station one can possibly reach
        // how to check if we can reach there is by checking if the stop i+1 is within reach

        int currentPos = 0;
        int numStops = 0;

        int i = -1; // starting with -1 station
        while (i < stops.length && (currentPos + tank < dist)) {
            int lastPos = currentPos;

            // check if we can reach the i+1 th station from the current station
            while (i + 1 < stops.length && (lastPos + tank >= stops[i + 1])) {
                // update the current location if the station is reachable,
                // here we are updating the current location but not refueling
                currentPos = stops[i + 1];
                i++;
            }

            if (lastPos == currentPos) return -1;
            if (currentPos < dist) {
                numStops++;
            }
        }
        if (currentPos + tank >= dist) return numStops;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
