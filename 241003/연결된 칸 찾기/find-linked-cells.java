import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int totalCount = 0;
        ArrayList<Integer> counts = new ArrayList<>();

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                    totalCount++;
                    counts.add(bfs(i, j));
                }
            }
        }

        Collections.sort(counts);
        System.out.println(totalCount);
        for (int count: counts) {
            System.out.println(count);
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int bfs(int x, int y) {
        int count = 1;
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y));

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();
            for (int i=0;i<4;i++) {
                int _x = now.x + dx[i];
                int _y = now.y + dy[i];

                if (_x < 0 || _x >= n || _y < 0 || _y >= n) continue;
                if (graph[_x][_y] == 0) continue;
                graph[_x][_y] = 0;
                count++;
                dq.add(new Node(_x, _y));
            }
        }
        return count;
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