import java.util.*;
import java.io.*;

public class Main {
    static Point[] points;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        points = new Point[N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        int M = N;
        for (Point point1: points) {
            for (Point point2: points) {
                M = Math.min(M, count(point1.x+1, point2.y+1));
                M = Math.min(M, count(point1.x+1, point2.y-1));
                M = Math.min(M, count(point1.x-1, point2.y+1));
                M = Math.min(M, count(point1.x-1, point2.y-1));
            }
        }
        System.out.println(M);
    }

    static int count(int x, int y) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        for (Point point: points) {
            if (point.y > y) {
                if (point.x < x) {
                    c1++;
                } else {
                    c2++;
                }
            } else {
                if (point.x < x) {
                    c3++;
                } else {
                    c4++;
                }
            }
        }
        return Arrays.stream(new int[]{c1, c2, c3, c4}).max().getAsInt();
    }
    
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}