import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Point[] points = new Point[N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        // y축 평행 직선 - 이분탐색
        if (R % 2 != 0) {
            R--;
        }
        int down = 0;
        int up = R;
        int y = 0;
        int count = N;
        while (down <= up) {
            int mid = (down + up) / 2 - 1;
            int dpoint = 0;
            int upoint = 0;
            for (Point point: points) {
                if (point.y < mid) {
                    dpoint++;
                } else {
                    upoint++;
                }
            }
            if (dpoint > upoint && count > dpoint) {
                if (count > dpoint) {
                    count = dpoint;
                    y = mid;
                }
                up = mid - 2;
            } else {
                if (count < upoint) {
                    count = upoint;
                    y = mid;
                }
                down = mid + 2;
            }
        }

        // x축 평행 직선 - 이분탐색
        int left = 0;
        int right = R;
        count = N;
        while (left <= right) {
            int mid = (left + right) / 2 - 1;
            int ulpoint = 0;
            int urpoint = 0;
            int dlpoint = 0;
            int drpoint = 0;
            for (Point point: points) {
                if (point.y > y) {
                    if (point.x < mid) {
                        ulpoint++;
                    } else {
                        urpoint++;
                    }
                } else {
                    if (point.x < mid) {
                        dlpoint++;
                    } else {
                        drpoint++;
                    }
                }
            }
            // System.out.println(ulpoint + " " +urpoint + " " + dlpoint + " " + drpoint);
            int maxPoint = Arrays.stream(new int[]{ulpoint, urpoint, dlpoint, drpoint}).max().getAsInt();
            if (maxPoint < count) {
                count = maxPoint;
                if (maxPoint == ulpoint || maxPoint == dlpoint) {
                    right = mid - 2;
                } else {
                    left = mid + 2;
                }
            } else {
                break;
            }
        }
        System.out.println(count);

    }
    
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}