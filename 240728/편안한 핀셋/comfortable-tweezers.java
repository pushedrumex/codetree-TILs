import java.util.*;
import java.io.*;

public class Main {

    static int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[1000][1000];
        int[][] pinCount = new int[1000][1000];

        int answer = 0;
        for (int k=0;k<N;k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;

            for (int[] d: dxdy) {
                int _x = x + d[0];
                int _y = y + d[1];
                if (_x < 0 || _x >= N || _y < 0 || _y >= N) {
                    continue;
                }
                pinCount[_x][_y]++;
                if (graph[_x][_y] == false) {
                    continue;
                }
                if (pinCount[_x][_y] == 3) {
                    answer++;
                } else if (pinCount[_x][_y] == 4) {
                    answer--;
                }
            }

            System.out.println(answer);
        }
    }
}