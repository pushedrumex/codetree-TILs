import java.util.*;
import java.io.*;

public class Main {
    static int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[N][N];
        for (int k=0;k<N;k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            int answer = 0;
            for (int i=0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    if (graph[i][j] == false) {
                        continue;
                    }
                    int pin = 0;
                    for (int[] d: dxdy) {
                        int _i = i + d[0];
                        int _j = j + d[1];
                        if (_i < 0 || _i >= N || _j < 0 || _j >= N || graph[_i][_j] == false) {
                            continue;
                        }
                        pin++;
                    }
                    if (pin == 3) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}