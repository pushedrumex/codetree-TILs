import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] energy = new int[n];
        int[] happy = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[101][n+1];
        for (int e=1;e<=100;e++) {
            for (int i=1;i<=n;i++) {
                if (energy[i-1] > e) {
                    dp[e][i] = dp[e][i-1];
                    continue;
                }
                dp[e][i] = Math.max(dp[e][i-1], dp[e-energy[i-1]][i-1]+happy[i-1]);
            }
        }
        System.out.println(dp[100][n]);
    }
}