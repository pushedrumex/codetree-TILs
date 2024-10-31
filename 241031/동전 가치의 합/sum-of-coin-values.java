import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[m+1];
        dp[0] = 1;
        // i번째 동전으로
        for (int i=0;i<n;i++) {
            int coin = coins[i];
            // j원 만들기
            for (int j=coin;j<=m;j++) {
                dp[j] += dp[j-coin];
                dp[j] %= 1_000_000_007;
            }
        }
        if (dp[m] == 0) dp[m] = -1;
        System.out.println(dp[m]);
    }
}