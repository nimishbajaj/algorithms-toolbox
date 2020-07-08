import java.util.*;
import java.io.*;

public class MajorityElement {
    static int countNum(int[] a, int num, int left, int right) {
        int count = 0;
        for (int i = left; i < right; i++) {
            if (a[i] == num) count++;
        }

        return count;
    }

    private static int getMajorityElementNaive(int[] a) {
        for (int num : a) {
            int count = 0;
            for (int i : a) {
                if (i == num) count++;
            }
            if (count > a.length / 2) return num;
        }
        return -1;
    }


    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) return -1;

        if (left + 1 == right) return a[left];

        int mid = left + (right - left) / 2;
        int leftMajority = getMajorityElement(a, left, mid);
        int rightMajority = getMajorityElement(a, mid, right);

        if (leftMajority == rightMajority && leftMajority != -1) return leftMajority;

        int leftCount = countNum(a, leftMajority, left, right);
        int rightCount = countNum(a, rightMajority, left, right);

        if (leftCount > (right - left) / 2) return leftMajority;
        if (rightCount > (right - left) / 2) return rightMajority;

        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

// Some good test cases to validate your own code
//        3 3 2 3 2 4 0 3 3 3
//        -1 3
//        3 1 1 1 0 1 3 1 1 3
//        -1 1
//        1 2 1 2 1 1 2 1 1 1
//        -1 1
//        3 0 0 3 0 3 0 0 0 1
//        -1 0
//        0 0 0 2 4 1 0 0 0 0
//        -1 0
//        4 0 0 4 1 4 4 4 4 1
//        -1 4
