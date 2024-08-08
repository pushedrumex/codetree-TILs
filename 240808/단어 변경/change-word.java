import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] start = br.readLine().split("");
        String[] end = br.readLine().split("");
        int[][] dp = new int[n+1][m+1];

        // LCS(최장 공통 부분 수열)
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++) {
                if (start[i-1].equals(end[j-1]) ||
                (start[i-1].equals("i") && (end[j-1].equals("j") || end[j-1].equals("l"))) ||
                (start[i-1].equals("v") && end[j-1].equals("w"))) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        int answer = m + Math.abs(n-m) - dp[n][m];
        System.out.println(answer);
    }
}