package src.week3;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        // sort by the ending times
        Arrays.sort(segments, new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return o1.start - o2.start;
            }
        });

//        System.out.println(Arrays.toString(segments));

        Stack<Segment> stack = new Stack<>();
        for (Segment s : segments) {
            if (stack.empty() || s.start > stack.peek().end) {
                stack.push(s);
            } else {
                Segment temp = stack.pop();
                int start = Math.max(temp.start, s.start);
                int end = Math.min(temp.end, s.end);
                stack.push(new Segment(start, end));
            }
        }

//        System.out.println(stack);

        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i).end;
        }

        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
