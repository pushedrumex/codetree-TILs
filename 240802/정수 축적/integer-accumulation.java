import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] values = new int[n];
        for (int i=0;i<n;i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        
        int[][] dp = new int[n+1][m+1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++) {
                if (j > n-i) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+values[i-1]);
            }
        }

        System.out.println(dp[n][m]);
    }
}