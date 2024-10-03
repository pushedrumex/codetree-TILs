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

        dfs(0, 0);
        
        System.out.println(answer);
    }

    static void dfs(int i, int l) {
        if (l >= answer) return;

        if (i == N) {
            answer = Math.min(answer, l);
            return;
        }

        for (int k=1;k<=N;k++) {
            if (visited[k] == false) {
                visited[k] = true;
                order[k] = i;
                int _l = 0;
                for (int j=0;j<3;j++) {
                    if (visited[friend[k][j]] == true) _l += Math.abs(order[k] - order[friend[k][j]]);
                }
                dfs(i+1, l+_l);
                visited[k] = false;
            }
        }
    }
}