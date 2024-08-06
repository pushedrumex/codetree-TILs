import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int turn = 0;
        int[][] dxdy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (true) {
            boolean change = false;
            ArrayList<Node> nodes = new ArrayList<>();
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    if (graph[i][j] == 1) {
                        nodes.add(new Node(i, j));
                    }
                }
            }
            for (Node node: nodes) {
                for (int[] d: dxdy) {
                    int x = node.x + d[0];
                    int y = node.y + d[1];
                    if (x < 0 || x >= n || y < 0 || y >=m || graph[x][y] != 0) continue;
                    change = true;
                    graph[x][y] = 1;
                }
            }
            if (change == true ) turn++;
            else break;
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(turn);
    }

    static class Node {
        int x;
        int y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}