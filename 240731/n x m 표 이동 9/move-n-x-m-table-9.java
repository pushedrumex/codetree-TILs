import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] graph;
    static boolean[][][] visited;
    static int[][] dxdy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0][graph[0][0]] = true;
        bfs(0, 0);
        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        if (graph[x][y] == 1) {
            dq.add(new Node(x, y, 1, 1));
        } else {
            dq.add(new Node(x, y, 1, 0));
        }
        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();

            if (now.x == n-1 && now.y == m-1) {
                answer = now.count;
                return;
            }

            for (int[] d: dxdy) {
                int _x = now.x + d[0];
                int _y = now.y + d[1];
                if (_x < 0 || _x >= n || _y < 0 || _y >= m || visited[_x][_y][graph[_x][_y]]) {
                    continue;
                }
                if (now.one == 1 && graph[_x][_y] == 1) {
                    continue;
                }
                
                if (graph[_x][_y] == 1) {
                    visited[_x][_y][1] = true;
                    dq.add(new Node(_x, _y, now.count+1, 1));
                } else {
                    visited[_x][_y][now.one] = true;
                    dq.add(new Node(_x, _y, now.count+1, now.one));
                }
            }
        }
    }
    static class Node {
        int x, y, count;
        int one;
        Node(int x, int y, int count, int one) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.one = one;
        }
    }
}