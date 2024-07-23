import java.util.*;
import java.io.*;

public class Main {
    static int M;
    static Point[] points;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        points = new Point[N];
        M = N;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        dfs(0, R, 0, R);
        System.out.println(M);
    }

    // dfs + 이분탐색
    static void dfs(int left, int right, int down, int up) {

        if (left > right || down > up) {
            return;
        }

        int xMid = (left + right) / 2;
        int yMid = (down + up) / 2;
        if (xMid % 2 != 0) {
            xMid++;
        }
        if (yMid % 2 != 0) {
            yMid++;
        }

        int ulCount = 0;
        int urCount = 0;
        int dlCount = 0;
        int drCount = 0;
        for (Point point: points) {
            if (point.y > yMid) {
                if (point.x < xMid) {
                    ulCount++;
                } else {
                    urCount++;
                }
            } else {
                if (point.x < xMid) {
                    dlCount++;
                } else {
                    drCount++;
                }
            }
        }

        int maxCount = Arrays.stream(new int[]{ulCount, urCount, dlCount, drCount}).max().getAsInt();
        if (maxCount <= M) {
            M = maxCount;
            if (maxCount == ulCount) {
                dfs(left, xMid-2, down, up);
                dfs(left, right, yMid+2, up);
            } else if (maxCount == urCount) {
                dfs(xMid+2, right, down, up);
                dfs(left, right, yMid+2, up);
            } else if (maxCount == dlCount) {
                dfs(left, right, down, yMid-2);
                dfs(left, xMid-2, down, up);
            } else {
                dfs(xMid+2, right, down, up);
                dfs(left, right, down, yMid-2);
            }
        }
    }
    
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}