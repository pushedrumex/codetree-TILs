import java.util.*;
import java.io.*;

public class Main {
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = -Integer.MAX_VALUE;
    static String[][] graph;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new String[n][n];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                graph[i][j] = st.nextToken();
            }
        }
        dfs(0, 0, Integer.parseInt(graph[0][0]), "");
        System.out.println(maxValue + " " + minValue);
    }
    static int[][] dxdy = {{1, 0}, {0, 1}};
    static void dfs(int x, int y, int value, String op) {
        if (x == n-1 && y == n-1) {
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
            return;
        }
        for (int[] d: dxdy) {
            int _x = x + d[0];
            int _y = y + d[1];
            if (_x < 0 || _x >= n || _y < 0 || _y >= n) continue;
            if (graph[_x][_y].equals("+") || graph[_x][_y].equals("-") || graph[_x][_y].equals("x")) {
                dfs(_x, _y, value, graph[_x][_y]);
            } else {
                int n = Integer.parseInt(graph[_x][_y]);
                if (op.equals("+")) {
                    dfs(_x, _y, value+n, "");
                } else if (op.equals("-")) {
                    dfs(_x, _y, value-n, "");
                } else if (op.equals("x")) {
                    dfs(_x, _y, value*n, "");
                }
            }
        }
    }
}