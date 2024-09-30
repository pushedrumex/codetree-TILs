import java.util.*;
import java.io.*;

public class Main {
    static int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int M;
    static int N;
    static int[][] graph;
    static int[][] color;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[M][N];

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        color = new int[M][N];
        int count = 0;
        int startX = 0;
        int startY = 0;
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
                if (color[i][j] == 1) {
                    count++;
                    startX = i;
                    startY = j;
                }
            }
        }

        int left = 0;
        int right = 1_000_000_000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int result = bfs(startX, startY, mid);
            if (result == count) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static int bfs(int x, int y, int D) {
        int result = 1;
        boolean[][] visited = new boolean[M][N];
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(x, y));
        visited[x][y] = true;
        while (!dq.isEmpty()) {
            Node node = dq.removeFirst();
            for (int[] d: dxdy) {
                int _x = node.x + d[0];
                int _y = node.y + d[1];
                if (_x < 0 || _x >= M || _y < 0 || _y >= N || visited[_x][_y]) continue;
                if (Math.abs(graph[node.x][node.y] - graph[_x][_y]) > D) continue;
                result += color[_x][_y];
                visited[_x][_y] = true;
                dq.addLast(new Node(_x, _y));
            }
        }
        return result;
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}