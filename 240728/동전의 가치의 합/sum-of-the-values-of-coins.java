import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = {1, 2, 5, 7};
        int[] dp = new int[n+1];
        Arrays.fill(dp, (int)Math.pow(10, 6));
        for (int coin: coins) {
            dp[coin] = 1;
        }
        for (int i=1;i<=n;i++) {
            for (int coin: coins) {
                if (i < coin) {
                    break;
                }
                dp[i] = Math.min(dp[i-coin]+1, dp[i]);
            }
        }
        System.out.println(dp[n]);
        // 여기에 코드를 작성해주세요.
    }
}