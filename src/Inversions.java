import java.util.*;

public class Inversions {

    private static int mergeSort(int[] a, int left, int right) {
        int mid, count = 0;
        if (left + 1 < right) {
            mid = left + (right - left) / 2;
            count += mergeSort(a, left, mid);
            count += mergeSort(a, mid, right);
            count += merge(a, left, mid, right);
        }
        return count;
    }


    private static int merge(int[] a, int left, int mid, int right) {
        int[] ls = Arrays.copyOfRange(a, left, mid);
        int[] rs = Arrays.copyOfRange(a, mid, right);

        int l = 0, r = 0, k = left, count = 0;
        while (l < ls.length && r < rs.length) {
            if (ls[l] <= rs[r]) a[k++] = ls[l++];
            else {
                a[k++] = rs[r++];
                count += mid - left - l;
            }
        }

        while (l < ls.length) a[k++] = ls[l++];
        while (r < rs.length) a[k++] = rs[r++];

        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(mergeSort(a, 0, a.length));
    }
}

