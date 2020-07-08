package src.week4;

import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length - 1;
        //write your code here

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == x) return mid;
            else if (x < a[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }

//        Random random = new Random(100);
//        int n = 100;
//        int[] a = new int[n];
//        int factor = 10;
//
//        a[0] = 1;
//        for(int i=1;i<n;i++){
//            a[i] = random.nextInt(factor)+a[i-1];
//        }
//
//        System.out.println(Arrays.toString(a));
//
//        int m = 10000;
//        int[] b= new int[m];
//        b[0] = 1;
//        for(int i=1;i<m;i++){
//            b[i] = random.nextInt(factor*n);
//        }
//
//        for (int i = 0; i < m; i++) {
//            //replace with the call to binarySearch when implemented
//            if(linearSearch(a, b[i])!=binarySearch(a, b[i]))
//            System.out.println(linearSearch(a, b[i]) + " " + binarySearch(a, b[i]));
//        }
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
