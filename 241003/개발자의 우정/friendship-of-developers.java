import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] friend;
    static int[] order;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        order = new int[N+1];
        friend = new int[N+1][3];
        visited = new boolean[N+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<3;j++) {
                friend[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        
        System.out.println(answer);
    }

    static void dfs(int i) {
        if (i == N) {
            int temp = 0;
            for (int o=1;o<=N;o++) {
                for (int j=0;j<3;j++) {
                    temp += Math.abs(order[o] - order[friend[o][j]]);
                }
            }
            answer = Math.min(answer, temp / 2);
        }
        for (int k=1;k<=N;k++) {
            if (visited[k] == false) {
                visited[k] = true;
                order[k] = i;
                dfs(i+1);
                visited[k] = false;
            }
        }
    }
}