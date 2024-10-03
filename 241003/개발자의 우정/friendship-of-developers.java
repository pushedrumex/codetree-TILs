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

    // 백트래킹
    static void dfs(int i) {
        int minCost = getMinCost(i);

        if (minCost >= answer) return;
        if (i == N) {
            answer = minCost;
            return;
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

    // 현재 상태의 가장 적은 비용
    static int getMinCost(int nowOrder) {
        int cost = 0;
        for (int i=1;i<=N;i++) {
            for (int j=0;j<3;j++) {
                int f = friend[i][j];
                if (visited[i] && visited[f]) {
                    cost += Math.abs(order[i] - order[f]);
                } else if (visited[i] && !visited[f]) {
                    cost += Math.abs(order[i] - nowOrder);
                } else if (!visited[i] && visited[f]) {
                    cost += Math.abs(nowOrder - order[f]);
                } else {
                    cost += 1;
                }
            }
        }
        return cost / 2;
    }
}