import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int n;
    static int m;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            graph = turn();
            answer++;
            int count = countSet();
            if (count == 0) {
                answer = -1;
                break;
            }
            if (count >= 2) {
                break;
            }
        }

        System.out.println(answer);
    }

    static int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] turn() {
        int[][] _graph = new int[n][m];
        for (int x=0;x<n;x++) {
            for (int y=0;y<m;y++) {
                int remove = 0;
                for (int[] d: dxdy) {
                    int _x = x + d[0];
                    int _y = y + d[1];
                    if (_x < 0 || _x >= n || _y < 0 || _y >= m) continue;
                    if (graph[_x][_y] == 0) {
                        remove++;
                    }
                }
                _graph[x][y] = Math.max(0, graph[x][y] - remove);
            }
        }
        return _graph;
    }
    
    static int countSet() {
        visited = new boolean[n][m];
        int count = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (graph[i][j] > 0 && visited[i][j] == false) {
                    count++;
                    bfs(i, j);
                }
            }
        }
        return count;
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y));

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();
            for (int[] d: dxdy) {
                int _x = now.x + d[0];
                int _y = now.y + d[1];
                if (_x < 0 || _x >= n || _y < 0 || _y >= m) continue;
                if (graph[_x][_y] == 0) continue;
                if (visited[_x][_y] == true) continue;
                visited[_x][_y] = true;
                dq.add(new Node(_x, _y));
            }
        }
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