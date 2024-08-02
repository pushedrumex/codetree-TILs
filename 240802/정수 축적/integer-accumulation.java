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
        // 일 인덱스
        for (int i=1;i<=n;i++) {
            // 최대 한계 피로도
            for (int j=1;j<=m;j++) {
                // 마지막에 피로도가 0이될 수 없다면
                if (j > n-i) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                // MAX(바로 일을 하는 것, 휴식 후 하는 것)
                dp[i][j] = dp[i-1][j-1]+values[i-1];
                if (i > j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-j][j-1]+values[i-1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}