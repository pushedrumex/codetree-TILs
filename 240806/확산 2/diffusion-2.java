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

        ArrayDeque<Node> dq = new ArrayDeque<>();
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    dq.add(new Node(i, j, 1));
                }
            }
        }

        int answer = 0;
        int[][] dxdy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!dq.isEmpty()) {
            Node node = dq.removeFirst();
            int x = node.x;
            int y = node.y;
            int turn = node.turn;
            for (int[] d: dxdy) {
                int _x = x + d[0];
                int _y = y + d[1];
                if (_x < 0 || _x >= n || _y < 0 || _y >=m || graph[_x][_y] != 0) continue;
                graph[_x][_y] = 1;
                answer = turn;
                dq.addLast(new Node(_x, _y, turn+1));
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int x;
        int y;
        int turn;
        Node (int x, int y, int turn) {
            this.x = x;
            this.y = y;
            this.turn = turn;
        }
    }
}