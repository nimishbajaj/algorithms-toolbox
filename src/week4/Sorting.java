package src.week4;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        int pivot = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= pivot) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        int t = a[l];
        a[l] = a[j];
        a[j] = t;


        int m1 = j;
        int m2 = j;
        for (int i = j - 1; i > l; i--) {
            if (a[i] == pivot) {
                m1--;
                t = a[i];
                a[i] = a[m1];
                a[m1] = t;
            }
        }


        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

//        int t = 1;
//        while(t-->0){
//            int n = 100000000;
//            int factor = 10;
//
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = random.nextInt(factor);
//            }
//
//            int[] a1 = a.clone();
//            int[] a2 = a.clone();
//
//            long startTime = System.nanoTime();
//            randomizedQuickSort(a1, 0, n - 1);
//            long endTime = System.nanoTime();
//
//            System.out.println("RandomSort Took "+(endTime - startTime) + " ns");
//
//            startTime = System.nanoTime();
//            Arrays.sort(a2);
//            endTime = System.nanoTime();
//            System.out.println("QuickSort Took "+(endTime - startTime) + " ns");
//
//            if(!Arrays.equals(a1, a2)){
//                System.out.println(Arrays.toString(a1));
//                System.out.println(Arrays.toString(a2));
//            }
//        }


        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

