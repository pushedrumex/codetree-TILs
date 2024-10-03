import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i=0;i<n;i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        dp[0] = 1;

        // 동전을 하나씩 사용
        for (int coin: coins) {
            // 돈을 만드는 경우의 수
            for (int money=coin;money<=k;money++) {
                dp[money] += dp[money-coin];
                dp[money] %= 1_000_000_007;
            }
        }
        System.out.println(dp[k]);
    }
}