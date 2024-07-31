import java.util.*;
import java.io.*;

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
        for (int i=1;i<m;i++) {
            graph[0][i] += graph[0][i-1];
            graph[i][0] += graph[i-1][0];
        }
        for (int i=1;i<n;i++) {
            for (int j=1;j<m;j++) {
                graph[i][j] += Math.max(graph[i-1][j], graph[i][j-1]);
            }
        }
        System.out.println(graph[n-1][m-1]);
    }
}