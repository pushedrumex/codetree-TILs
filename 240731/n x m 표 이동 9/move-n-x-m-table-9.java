import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dxdy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        dfs(0, 0, false, 1);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, boolean one, int count) {
        if (x == n-1 && y == m-1) {
            answer = Math.min(answer, count);
            return;
        }
        for (int[] d: dxdy) {
            int _x = x + d[0];
            int _y = y + d[1];
            if (_x < 0 || _x >= n || _y < 0 || _y >= m || visited[_x][_y]) {
                continue;
            }
            if (one == true && graph[_x][_y] == 1) {
                continue;
            }
            visited[_x][_y] = true;
            if (graph[_x][_y] == 1) {
                dfs(_x, _y, true, count+1);
            } else {
                dfs(_x, _y, one, count+1);
            }
            visited[_x][_y] = false;
        }
    }
}