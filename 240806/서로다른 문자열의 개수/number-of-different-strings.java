import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];

        // b의 개수 >= a의 개수
        for (int b=1;b<=n;b++) {
            dp[b][0] = 1;
            for (int a=1;a<=n;a++) {
                if (a > b) {
                    continue;
                }
                dp[b][a] = dp[b][a-1] + dp[b-1][a];
            }
        }
        System.out.println(dp[n][n]);
    }
}