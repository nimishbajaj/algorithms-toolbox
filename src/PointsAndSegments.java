import java.util.*;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[][] segments = getSortedSegments(starts, ends, points);
        int openSegments = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int point : points) {
            map.put(point, 0);
        }

        for (int[] s : segments) {
            if (s[1] == 0) openSegments++;
            if (s[1] == 2) openSegments--;
            if (s[1] == 1) {
                map.put(s[0], openSegments);
            }
        }

        int[] cnt = new int[points.length];
        for (int i = 0, pointsLength = points.length; i < pointsLength; i++) {
            cnt[i] = map.get(points[i]);
        }
        return cnt;
    }

    private static int[][] getSortedSegments(int[] starts, int[] ends, int[] points) {
        int[][] segments = new int[points.length + starts.length * 2][2];
        int k = 0;

        // add all the points
        for (int point : points) segments[k++] = new int[]{point, 1};

        // add all the segments
        for (int i = 0; i < starts.length; i++) {
            segments[k++] = new int[]{starts[i], 0};
            segments[k++] = new int[]{ends[i], 2};
        }

        // sort the points and segments
        Arrays.sort(segments, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if (x[0] == y[0]) {
                    return x[1] - y[1];
                } else return x[0] - y[0];
            }
        });

        return segments;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

